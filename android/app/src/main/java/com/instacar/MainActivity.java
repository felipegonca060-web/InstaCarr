package com.instacar;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    LinearLayout root, feed;
    int bg=Color.rgb(18,18,18);

    TextView text(String s,int size){
        TextView t=new TextView(this);
        t.setText(s); t.setTextSize(size); t.setTextColor(Color.WHITE);
        t.setPadding(20,18,20,18); return t;
    }
    Button button(String s){ Button b=new Button(this); b.setText(s); return b; }

    public void onCreate(Bundle b){super.onCreate(b); login();}

    void base(){
        root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(bg); setContentView(root);
    }

    void login(){
        base();
        TextView logo=text("🚘 InstaCar",32); logo.setGravity(Gravity.CENTER);
        root.addView(logo);
        root.addView(text("Sua garagem. Sua história. Sua comunidade.",15));
        EditText email=new EditText(this); email.setHint("E-mail ou usuário"); root.addView(email);
        EditText pass=new EditText(this); pass.setHint("Senha"); root.addView(pass);
        Button enter=button("ENTRAR"); root.addView(enter);
        Button register=button("CRIAR CONTA"); root.addView(register);
        enter.setOnClickListener(v->home());
        register.setOnClickListener(v->register());
    }

    void register(){
        base(); root.addView(text("Criar conta",28));
        EditText name=new EditText(this); name.setHint("Nome"); root.addView(name);
        EditText user=new EditText(this); user.setHint("@usuário"); root.addView(user);
        EditText email=new EditText(this); email.setHint("E-mail"); root.addView(email);
        EditText pass=new EditText(this); pass.setHint("Senha"); root.addView(pass);
        Button b=button("CRIAR CONTA"); root.addView(b);
        b.setOnClickListener(v->home());
    }

    void home(){
        base();
        LinearLayout top=new LinearLayout(this);
        TextView logo=text("InstaCar",26); top.addView(logo,new LinearLayout.LayoutParams(0,75,1));
        Button profile=button("👤"); top.addView(profile,new LinearLayout.LayoutParams(75,75));
        root.addView(top);

        ScrollView sv=new ScrollView(this);
        feed=new LinearLayout(this); feed.setOrientation(LinearLayout.VERTICAL);
        sv.addView(feed); root.addView(sv,new LinearLayout.LayoutParams(-1,0,1));

        Button create=button("＋ PUBLICAR"); root.addView(create);
        create.setOnClickListener(v->newPost());
        profile.setOnClickListener(v->profile());
        post("🚗 InstaCar", "Bem-vindo ao feed! Seu primeiro post pode aparecer aqui.");
        post("🏎️ Projeto", "Mostre seu carro, suas modificações e sua evolução.");
    }

    void post(String author,String caption){
        TextView p=text(author+"\n\n"+caption+"\n\n♡ Curtir    💬 Comentar    ↗ Compartilhar",17);
        p.setBackgroundColor(Color.rgb(35,35,35));
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,220);
        lp.setMargins(10,10,10,10); feed.addView(p,lp);
    }

    void newPost(){
        EditText c=new EditText(this); c.setHint("Legenda do post...");
        new AlertDialog.Builder(this).setTitle("Nova publicação").setView(c)
        .setPositiveButton("PUBLICAR",(d,w)->post("👤 Você",c.getText().toString()))
        .setNegativeButton("Cancelar",null).show();
    }

    void profile(){
        base(); root.addView(text("👤 Meu perfil",28));
        root.addView(text("@usuario\n\n🚘 Meu carro\n📍 Brasil\n\n0 seguidores   0 seguindo",19));
        root.addView(button("EDITAR PERFIL"));
        root.addView(button("MEUS CARROS"));
        Button back=button("← VOLTAR"); root.addView(back);
        back.setOnClickListener(v->home());
    }
}
