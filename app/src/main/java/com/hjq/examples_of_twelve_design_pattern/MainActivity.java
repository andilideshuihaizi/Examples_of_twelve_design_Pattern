package com.hjq.examples_of_twelve_design_pattern;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern.AppleUnPackFactory;
import com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern.BananaUnPackFactory;
import com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern.Box;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.Builder;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.ChinaBuilder;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.Director;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.Director_indian;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.EnglandBuilder;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.GameRole;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.IndiaBuilderIm;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.Indian;
import com.hjq.examples_of_twelve_design_pattern.Factory_pattern.AppleFactory;
import com.hjq.examples_of_twelve_design_pattern.Factory_pattern.BananaFactory;
import com.hjq.examples_of_twelve_design_pattern.Factory_pattern.Factory;
import com.hjq.examples_of_twelve_design_pattern.Simple_factory_pattern.Fruit;
import com.hjq.examples_of_twelve_design_pattern.Simple_factory_pattern.FruitFactory;
import com.hjq.examples_of_twelve_design_pattern.Singleton_Pattern.HungarySingleton;
import com.hjq.examples_of_twelve_design_pattern.Singleton_Pattern.StaticInnerClassSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tv ;
    private Button button;
    private int origin = 0;
    private TextView textView;
    private TextView title;

//    static {
//        System.loadLibrary("native-lib");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv =  findViewById(R.id.sample_text);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        title = findViewById(R.id.textView2);

        tv.setText(Integer.toString(0));
        button.setOnClickListener(this);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();

    private void OringinInit(){
        tv.setText(Integer.toString(0));
    }

    @Override
    public void onClick(View v) {
        if (tv.getText().toString().isEmpty()) {
            OringinInit();
            title.setText("title null");
            return;
        }

        if (origin == Integer.parseInt(tv.getText().toString().trim())) {
            Toast.makeText(MainActivity.this,"none pattern",Toast.LENGTH_SHORT).show();
            textView.setText("null");
            title.setText("title null");
            return;
        }

        switch (Integer.parseInt(tv.getText().toString())){
            case 1:
                FruitFactory factory = new FruitFactory();
                Fruit fruit = factory.getFruit("apple");
                Fruit fruit1 = factory.getFruit("banana");
                textView.setText(fruit.produce()+" "+fruit1.produce());
                title.setText("Simple_factory_pattern");
                OringinInit();
                break;
            case 2:
                Factory factory1 = new AppleFactory();
                com.hjq.examples_of_twelve_design_pattern.Factory_pattern.Fruit apple = factory1.getFruit();
                Factory factory2 = new BananaFactory();
                com.hjq.examples_of_twelve_design_pattern.Factory_pattern.Fruit banana = factory2.getFruit();
                textView.setText(apple.produce()+" "+banana.produce());
                title.setText("Factory_pattern");
                OringinInit();
                break;
            case 3:
                com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern.Factory factory3 = new AppleUnPackFactory();
                com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern.Fruit apple2 = factory3.getFruit();
                Box box = factory3.getBox();
                factory3 = null;
                factory3 = new BananaUnPackFactory();
                com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern.Fruit banana2 = factory3.getFruit();
                Box box1 = factory3.getBox();
                textView.setText(apple2.produce()+" "+box.produce()+"\t"+banana2.produce()+" "+box1.produce());
                title.setText("Abstract_factory_pattern");
                OringinInit();
                break;
            case 4:
                StringBuilder builder = new StringBuilder();
                GameRole gameRole = new Director(new ChinaBuilder()).getGameRole();
                builder.append(gameRole.getSkinColor()+"\\t"+gameRole.getHeight()+"\\t"+gameRole.getWeight()+"\\t");
                gameRole = null;
                gameRole = new Director(new EnglandBuilder()).getGameRole();
                builder.append(gameRole.getSkinColor()+"\\t"+gameRole.getHeight()+"\\t"+gameRole.getWeight()+"\\t");
                gameRole = null;
                gameRole = new Director_indian(new IndiaBuilderIm()).getGameRole();
                Indian indian = (Indian) gameRole;
                builder.append(indian.getName()+"\\t"+indian.getSkinColor()+"\\t"+indian.getHeight()+"\\t"+indian.getWeight()+"\\t");
                textView.setText(builder.toString());
                title.setText("Builder_Pattern");
                OringinInit();
                break;
            case 5:
                String result;
                HungarySingleton hungarySingleton = HungarySingleton.getInstance();
                ObjectOutputStream objectOutputStream = null;
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream("singletion"));
                    objectOutputStream.writeObject(hungarySingleton);
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("singletion"));
                    HungarySingleton hungarySingleton01 = (HungarySingleton) objectInputStream.readObject();
                    if (hungarySingleton.equals(hungarySingleton01))
                        result = "true";
                    else
                        result = "false";

                    textView.setText(result);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
                StaticInnerClassSingleton staticInnerClassSingleton2 = StaticInnerClassSingleton.getInstance();
                if (staticInnerClassSingleton.equals(staticInnerClassSingleton2))
                    result = "true";
                else
                    result = "false";
                
                textView.setText(textView.getText()+"\n"+result);
                break;
        }
    }
}
