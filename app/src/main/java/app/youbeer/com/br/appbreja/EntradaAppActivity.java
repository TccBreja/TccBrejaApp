package app.youbeer.com.br.appbreja;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Activity de entrada da aplicaçao com o loading
 *
 * @since 06/09/2016
 * @version 1.0
 */
public class EntradaAppActivity extends AppCompatActivity implements Runnable{


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_app);

        //Cria uma animação de loading de 5 imagens
        ImageView imageView = (ImageView)findViewById(R.id.animacaoHome);
        imageView.setBackgroundResource(R.drawable.animation);

        AnimationDrawable animation = (AnimationDrawable) imageView.getBackground();
        animation.start();

        //Seta o handller e o tempo da animação
        Handler handler = new Handler();
        handler.postDelayed(this, 3000);
    }

    public void run(){
        //Starta a activity próxima
        startActivity(new Intent(this, MenuPadraoActivity.class));
        finish();
    }




}
