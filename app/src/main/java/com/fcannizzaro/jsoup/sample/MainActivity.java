package com.fcannizzaro.jsoup.sample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.fcannizzaro.jsoup.annotations.JsoupProcessor;
import com.fcannizzaro.jsoup.sample.model.NPM;
import com.fcannizzaro.jsoup.sample.model.Package;
import com.squareup.picasso.Picasso;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        scrape.start();
    }

    private Thread scrape = new Thread(new Runnable() {
        @Override
        public void run() {

            try {

                Element body = Jsoup
                        .connect("https://www.npmjs.com/")
                        .get();

                final NPM npm = JsoupProcessor.from(body, NPM.class);

                if (npm == null) {
                    return;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        update(npm.packages);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    });

    private void update(final List<Package> packages) {

        SlimAdapter
                .create()
                .updateData(packages)
                .register(R.layout.item_package, new SlimInjector<Package>() {
                    @Override
                    public void onInject(final Package pack, IViewInjector view) {

                        view
                                .text(R.id.name, pack.name)
                                .text(R.id.version, pack.info.version)
                                .text(R.id.author, pack.info.author)
                                .text(R.id.description, pack.description)
                                .clicked(R.id.item, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.npmjs.com" + pack.link)));
                                    }
                                });

                        Picasso
                                .with(MainActivity.this)
                                .load(pack.icon)
                                .noFade()
                                .placeholder(R.drawable.box)
                                .error(R.drawable.box)
                                .into((ImageView) view.findViewById(R.id.icon));

                    }
                })
                .attachTo(list);

    }

}
