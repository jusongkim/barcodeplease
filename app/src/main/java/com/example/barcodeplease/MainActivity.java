package com.example.barcodeplease;

import static com.google.android.material.R.dimen.design_fab_size_normal;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.barcodeplease.databinding.ActivityMainBinding;

//import com.google.android.material.R;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private boolean isFabExpanded = false; // FAB 확장 상태를 추적하는 변수
    //private FloatingActionButton newFab;
    private static String TAG = "LifeCycle";

    //private FebButtonClickListener FebButtonClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate()");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.fabAddBar);

        //Feb Button Proc
        FebButtonClickListener FebButtonClickListener = new FebButtonClickListener();
        binding.appBarMain.fab.setOnClickListener(FebButtonClickListener);
        binding.appBarMain.fab2.setOnClickListener(FebButtonClickListener);



        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        Log.d(TAG, "onCreate()_3");

    }

    private void showNewFab() {
        binding.appBarMain.fab2.setVisibility(View.VISIBLE);

//        int fabSize = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_fab_size_normal);
//        int marginBetween = 40; // 버튼 간격
//        int baseMarginBottom = 100; // 첫 번째 FAB의 bottom margin
//
//
//        FloatingActionButton newFab = new FloatingActionButton(this);
//        newFab.setId(View.generateViewId());
//        newFab.setImageResource(android.R.drawable.ic_dialog_email);
//        newFab.setSize(FloatingActionButton.SIZE_MINI);

        //CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(
        //        ViewGroup.LayoutParams.WRAP_CONTENT,
        //        ViewGroup.LayoutParams.WRAP_CONTENT
        //);
        //params.gravity = Gravity.END | Gravity.BOTTOM;
        //params.rightMargin = 40; // 오른쪽 여백
        //params.bottomMargin = baseMarginBottom + 1 * (fabSize + marginBetween);

        //newFab.setLayoutParams(params);
//        binding.getRoot().addView(newFab);


        ///////////////////////////////////////////////////////////
//        newFab = new FloatingActionButton(this);
//        newFab.setId(View.generateViewId()); //고유 ID생성
//        newFab.setImageResource(android.R.drawable.ic_dialog_info);
//        //newFab.setSize(FloatingActionButton.SIZE_MINI);
//        //newFab.setSize(binding.appBarMain.fab.getSize());
//
//        newFab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(v, "New FAB clicked!", Snackbar.LENGTH_SHORT).show();
//            }
//        });
//
//        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(
//                //CoordinatorLayout.LayoutParams.WRAP_CONTENT,
//                //CoordinatorLayout.LayoutParams.WRAP_CONTENT
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        );
//
//        layoutParams.setAnchorId(binding.appBarMain.fab.getId()); // 기존 FAB를 기준으로 위치 설정
//        layoutParams.gravity = Gravity.END | Gravity.BOTTOM; // 기존 FAB의 위쪽, 오른쪽 끝에 위치
//        //int margin = (int) getResources().getDimension(R.dimen.fab_margin); // res/values/dimens.xml에 fab_margin을 정의해야 합니다.
//        //layoutParams.bottomMargin = binding.appBarMain.fab.getMargin();
//        //layoutParams.rightMargin = margin;
//        //layoutParams.bottomMargin = 40;
//        layoutParams.bottomMargin = baseMarginBottom * (fabSize + marginBetween);
//
//        // 새로운 FAB를 CoordinatorLayout에 추가
//        binding.getRoot().addView(newFab, layoutParams);
    }


    private void hideNewFab() {
        // 새로운 FAB 제거
        binding.appBarMain.fab2.setVisibility(View.INVISIBLE);

    }
    class FebButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.fab2)
            {
                //fragement를 하나 띄어서 연결
                //입력 fragement는 바코드의 정보를 입력받고 생성//
                //UI구성
                //1. 코드타입
                //2. 코드정보 윗주석 안내조건 11자리+bla bla
                //3. 내용, Tag정보, 저장위치
                //4.. ㅅㄷㄴㅅ
                Snackbar.make(v, "fab222222222222", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
            else if(v.getId() == R.id.fab)
            {
                if(!isFabExpanded){
                    showNewFab();
                    isFabExpanded = true;
                }else{
                    hideNewFab();
                    isFabExpanded = false;
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}