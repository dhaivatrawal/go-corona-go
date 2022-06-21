package com.zedr_apps.cvd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.anshulthakur.networkstatechecker.InternetStateChecker;


public class MainActivity extends AppCompatActivity {

    InternetStateChecker checker;
    ImageView share,rateMe;
    private ImageView button;
    CardView ccdone,ccdtwo,ccdthree,ccdfour,ccdfive,ccdsix,ccdseven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checker = new InternetStateChecker.Builder(this).build();
        CardView ccdone = findViewById(R.id.ccdone);
        CardView ccdtwo = findViewById(R.id.ccdtwo);
        CardView ccdthree = findViewById(R.id.ccdthree);
        CardView ccdfour = findViewById(R.id.ccdfour);
        CardView ccdfive = findViewById(R.id.ccdfive);
        CardView ccdsix = findViewById(R.id.ccdsix);
        CardView ccdseven = findViewById(R.id.ccdseven);

        ccdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ShowingUrl.class);
                startActivity(intent);
            }
        });
        ccdtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Country.class);
                startActivity(intent);
            }
        });
        ccdthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Symptoms.class);
                startActivity(intent);
            }
        });
        ccdfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Protection.class);
                startActivity(intent);
            }
        });
        ccdfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Sick.class);
                startActivity(intent);
            }
        });
        ccdsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Cases.class);
                startActivity(intent);
            }
        });
        ccdseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),News.class);
                startActivity(intent);
            }
        });
        ImageView share=findViewById(R.id.share);
        ImageView rateMe=findViewById(R.id.rateMe);

        rateMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Intent.ACTION_SEND);
                final  String appPackageNAm = getApplicationContext().getPackageName();
                String strAppLink ="";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + appPackageNAm)));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageNAm)));
                }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Intent.ACTION_SEND);
                final  String appPackageNAme = getApplicationContext().getPackageName();
                String strAppLink ="";

                try
                {
                    strAppLink = "http://play.google.com/store/apps/details?id=" + appPackageNAme;
                }
                catch (android.content.ActivityNotFoundException anfe)
                {
                    strAppLink = "https:/play.google.com/store/apps/details?id=" + appPackageNAme;
                }
                a.setType("text/link");
                String sharebody = "This App is basically on Awareness about the Deadly Virus named CoronaVirus.\n"+"This application contains Information, Cure and Precautions about CoronaVirus\n\n"+"-Active Cases\n"+"-Infected Countries List\n"+"-Protection from CoronaVirus\n"+"-Symptoms\n"+"-Causes\n"+"-Latest News\n" + "\n"+""+strAppLink;
                String sharesub = "APP NAME ";
                a.putExtra(Intent.EXTRA_SUBJECT,sharesub);
                a.putExtra(Intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(a,"Share Using"));
            }

        });

        button = (ImageView) findViewById(R.id.buttonShowCustomDialog);

        // add button listener
        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {

                // custom dialog
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom);

                // set the custom dialog components - text, image and button
                TextView title_law = (TextView) dialog.findViewById(R.id.title_law);
                title_law.setText("CoronaVirus");
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("This App is basically on Awareness about the Deadly Virus named CoronaVirus.\n"+"This application contains Information, Cure and Precautions about CoronaVirus\n\n"+"-Active Cases\n"+"-Infected Countries List\n"+"-Protection from CoronaVirus\n"+"-Symptoms\n"+"-Causes\n"+"-Latest News\n");
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(R.drawable.loogo);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        checker.stop();
    }
}
