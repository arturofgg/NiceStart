package com.example.nicestart;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class nopeople extends AppCompatActivity {

    // Declaración de variables
    private WebView miVisorWeb;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el diseño de la actividad
        setContentView(R.layout.nopeople);

        WebView mycontext = (WebView) findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);

        // Inicializa el SwipeRefreshLayout con el identificador myswipe del archivo de diseño XML
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);

        // Configura el listener de actualización con la instancia de mOnRefreshListener
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        //La vista dentro es un webview con permiso para zoom
        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
//        miVisorWeb.getSettings().setJavaScriptEnabled(true);
//        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        WebSettings webSettings = miVisorWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");
    }

    // Listener de actualización
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener =
            new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    // Muestra un mensaje de tostada indicando que algo no existe
                    Toast toast0 = Toast.makeText(nopeople.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
                    toast0.show();

                    // Recarga el contenido de miVisorWeb (asegúrate de inicializar miVisorWeb antes de llamar a reload())
                    miVisorWeb.reload();

                    // Indica que la animación de actualización se ha completado
                    swipeLayout.setRefreshing(false);
                }
            };
}