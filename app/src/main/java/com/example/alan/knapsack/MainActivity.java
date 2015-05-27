package com.example.alan.knapsack;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    int i;
    int j;
    int[] size = {3,4,7,8,9};
    int[] value = {4,5,10,11,13};
    int capacity=16;
    int[][] D= new int[100][100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*base solution*/

        for( i=0; i<capacity; i++){
             D[i][0]=i/size[0];
        }

        for( j=0; j<size.length; j++){
            D[0][j]=0;
        }

       for(i=1; i<=capacity; i++) {
            for (j = 1; j < size.length; j++) {
                if (i<size[j]){
                    D[i][j]=D[i][j-1];
                    Log.i("test", "i= "+Integer.toString(i)+" j="+Integer.toString(j)+ " D= "+Integer.toString(D[i][j]));
                }
                else{

                    D[i][j] = Math.max(     D[i - size[j]][j] + value[j],                  D[i][j - 1]);
                    Log.i("test", "i= "+Integer.toString(i)+" j="+Integer.toString(j)+ " D= "+Integer.toString(D[i][j]));
                }

            }
        }
        Log.i("test", Integer.toString(D[i][j]));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
