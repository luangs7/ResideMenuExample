package br.com.luan2.residemenuexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    ResideMenu resideMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.city);

        resideMenu.attachToActivity(this);

        // create menu items;
        String titles[] = { "Home", "Profile" };
        int icon[] = { android.R.drawable.ic_delete,android.R.drawable.ic_delete};
        int ind = 0;
        for (int i = 0; i < titles.length; i++){
            ind = i;
            ResideMenuItem item = new ResideMenuItem(this, icon[i], titles[i]);
            resideMenu.addMenuItem(item,  ResideMenu.DIRECTION_LEFT); // or  ResideMenu.DIRECTION_RIGHT
        }

        resideMenu.openMenu(ResideMenu.DIRECTION_LEFT); // or ResideMenu.DIRECTION_RIGHT
        resideMenu.closeMenu();

        resideMenu.setMenuListener(menuListener);

    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(Main2Activity.this, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(Main2Activity.this, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }


    @Override
    public void onClick(View v) {

    }
}
