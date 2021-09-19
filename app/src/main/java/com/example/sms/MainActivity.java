package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView w = findViewById(R.id.web);
        w.setWebViewClient(new WebViewClient());
        w.setWebChromeClient(new WebChromeClient());


        //habilitando a execução de javascript
        WebSettings conf = w.getSettings();
        conf.setJavaScriptEnabled(true);

        w.addJavascriptInterface(new Ponte(this), "Chamada");

        w.loadUrl("file:///android_asset/index.html");
    }

    public class Ponte {
        Context contexto;

        public Ponte(Context contexto) {
            this.contexto = contexto;
        }

        @JavascriptInterface
        public void enviaSms(String numero, String mensagem) {
            try {
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(numero, null, mensagem, null, null);
                Toast.makeText(this.contexto, "SMS Enviado", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(this.contexto, "Erro no Envio:"+ex.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}