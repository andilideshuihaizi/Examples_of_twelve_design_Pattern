package com.hjq.examples_of_twelve_design_pattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern.AppleUnPackFactory;
import com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern.BananaUnPackFactory;
import com.hjq.examples_of_twelve_design_pattern.Abstract_factory_pattern.Box;
import com.hjq.examples_of_twelve_design_pattern.Adapter_Pattern.Adaptee;
import com.hjq.examples_of_twelve_design_pattern.Adapter_Pattern.ConcreateTarget;
import com.hjq.examples_of_twelve_design_pattern.Adapter_Pattern.ObjectAdapter;
import com.hjq.examples_of_twelve_design_pattern.Adapter_Pattern.adapterClass;
import com.hjq.examples_of_twelve_design_pattern.Bridge_Pattern.ConvertDataToFile;
import com.hjq.examples_of_twelve_design_pattern.Bridge_Pattern.ConvertDataToTxtFile;
import com.hjq.examples_of_twelve_design_pattern.Bridge_Pattern.ConvertToPdfFile;
import com.hjq.examples_of_twelve_design_pattern.Bridge_Pattern.MysqlDBConnection;
import com.hjq.examples_of_twelve_design_pattern.Bridge_Pattern.OracleDBConnection;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.ChinaBuilder;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.Director;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.Director_indian;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.EnglandBuilder;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.GameRole;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.IndiaBuilderIm;
import com.hjq.examples_of_twelve_design_pattern.Builder_Pattern.Indian;
import com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Transparent_type.File;
import com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Transparent_type.Folder;
import com.hjq.examples_of_twelve_design_pattern.Decorator_Pattern.Animal;
import com.hjq.examples_of_twelve_design_pattern.Decorator_Pattern.AnimalDecorator;
import com.hjq.examples_of_twelve_design_pattern.Decorator_Pattern.Cat;
import com.hjq.examples_of_twelve_design_pattern.Decorator_Pattern.Pig;
import com.hjq.examples_of_twelve_design_pattern.Decorator_Pattern.WhiteAnimalDecorator;
import com.hjq.examples_of_twelve_design_pattern.Decorator_Pattern.YellowAnimalDecotator;
import com.hjq.examples_of_twelve_design_pattern.Facade_Pattern.CreateOrderFacade;
import com.hjq.examples_of_twelve_design_pattern.Factory_pattern.AppleFactory;
import com.hjq.examples_of_twelve_design_pattern.Factory_pattern.BananaFactory;
import com.hjq.examples_of_twelve_design_pattern.Factory_pattern.Factory;
import com.hjq.examples_of_twelve_design_pattern.Flyweight_Pattern.Circle;
import com.hjq.examples_of_twelve_design_pattern.Flyweight_Pattern.ShapeFactory;
import com.hjq.examples_of_twelve_design_pattern.Prototype_Pattern.Mail;
import com.hjq.examples_of_twelve_design_pattern.Prototype_Pattern.MailTemplate;
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
                textView.setText(fruit.produce()+"\n"+fruit1.produce());
                title.setText("Simple_factory_pattern");
                OringinInit();
                break;
            case 2:
                Factory factory1 = new AppleFactory();
                com.hjq.examples_of_twelve_design_pattern.Factory_pattern.Fruit apple = factory1.getFruit();
                Factory factory2 = new BananaFactory();
                com.hjq.examples_of_twelve_design_pattern.Factory_pattern.Fruit banana = factory2.getFruit();
                textView.setText(apple.produce()+"\n"+banana.produce());
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
                textView.setText(apple2.produce()+" "+box.produce()+"\n"+banana2.produce()+" "+box1.produce());
                title.setText("Abstract_factory_pattern");
                OringinInit();
                break;
            case 4:
                StringBuilder builder = new StringBuilder();
                GameRole gameRole = new Director(new ChinaBuilder()).getGameRole();
                builder.append(gameRole.getSkinColor()+"\t"+gameRole.getHeight()+"\t"+gameRole.getWeight()+"\t");
                builder.append("\n");
                gameRole = null;
                gameRole = new Director(new EnglandBuilder()).getGameRole();
                builder.append(gameRole.getSkinColor()+"\t"+gameRole.getHeight()+"\t"+gameRole.getWeight()+"\t");
                builder.append("\n");
                gameRole = null;
                gameRole = new Director_indian(new IndiaBuilderIm()).getGameRole();
                Indian indian = (Indian) gameRole;
                builder.append(indian.getName()+"\t"+indian.getSkinColor()+"\t"+indian.getHeight()+"\t"+indian.getWeight()+"\t");
                builder.append("\n");
                textView.setText(builder.toString());
                title.setText("Builder_Pattern");
                OringinInit();
                break;
            case 5:
                String result=null;
                textView.setText("null ");
                HungarySingleton hungarySingleton = HungarySingleton.getInstance();
                ObjectOutputStream objectOutputStream = null;
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream("singletion"));
                    objectOutputStream.writeObject(hungarySingleton);
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("singletion"));
                    HungarySingleton hungarySingleton01 = (HungarySingleton) objectInputStream.readObject();
                    if (hungarySingleton.equals(hungarySingleton01))
                        result = "true1";
                    else
                        result = "false1";

                    textView.setText(result);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
                StaticInnerClassSingleton staticInnerClassSingleton2 = StaticInnerClassSingleton.getInstance();
                if (staticInnerClassSingleton.equals(staticInnerClassSingleton2))
                    result = "true2";
                else
                    result = "false2";

                title.setText("Singleton_Pattern");
                textView.setText(textView.getText()+"\n"+result);
                OringinInit();
                break;
            case 6:
                StringBuilder stringBuilder = new StringBuilder();
                Mail mail = new Mail(new MailTemplate("this is subject","this is content"));
                for (int i = 0;i<5;i++){
                    try {
                        Mail mail1 = mail.getCloneClass();
                        mail1.setReceiver("Receiver:"+ Integer.toString(i));
                        stringBuilder.append(mail1.sendEmail());
                        stringBuilder.append("\n \t");
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                }
                title.setText("Prototype_Pattern");
                textView.setText(stringBuilder.toString());
                OringinInit();
                break;
            case 7:
                CreateOrderFacade createOrderFacade = new CreateOrderFacade();
                String ret = createOrderFacade.creatOrder("patato","xiao");
                String ret2 = createOrderFacade.creatOrder("banana","fei");

                title.setText("Facade_Pattern");
                textView.setText("ret:"+ret+"\n"+"ret2:"+ret2);
                OringinInit();
                break;
            case 8:
                Animal animal = new Cat();
                String game = animal.getGame();
                AnimalDecorator animal1 = new WhiteAnimalDecorator(animal);
                game+="***"+animal1.getGame()+"\n";

                animal = new Pig();
                AnimalDecorator animalDecorator = new YellowAnimalDecotator(animal);
                game+= animal.getGame()+"***"+animalDecorator.getGame()+"\n";
                title.setText("Decorator_Pattern");
                textView.setText(game);
                OringinInit();
                break;
            case 9:
                adapterClass adapterClass = new adapterClass(new ConcreateTarget(),new Adaptee());
                String ada = adapterClass.method();
                ObjectAdapter adapter = new ObjectAdapter(new Adaptee());
                ada+="\n"+adapter.method();

                title.setText("Adapter_Pattern");
                textView.setText(ada);
                OringinInit();
                break;
            case 10:
                String num = "";
                File txtFile = new File("txt");
                File pdfFile = new File("pdf");
                File docFile = new File("doc");
                File javaFile = new File("java");
                File mp3File = new File("mp3");

                Folder commonFolder = new Folder("commonFolder");
                num="commonFile num"+"\t"+commonFolder.add(txtFile)+"\t"+commonFolder.add(pdfFile)+"\t"+commonFolder.add(docFile)+"\n";

                Folder codeFolder = new Folder("codeFolder");
                num+="codeFile num"+"\t"+codeFolder.add(javaFile)+"\n";

                Folder audioFolder = new Folder("musicFolder");
                num+="musicFile num"+"\t"+audioFolder.add(mp3File)+"\n";

                Folder root = new Folder("root");
                num+="rootFolder num"+"\t"+root.add(commonFolder)+"\t"+root.add(codeFolder)+"\t"+root.add(audioFolder)+"\n";

                num+=root.print("0");

                title.setText("Transparent_type");
                textView.setText(num);
                OringinInit();
                break;
            case 11:
                String num1 = "";
                com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.File txtFile1 = new com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.File("txt");
                com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.File pdfFile1 = new com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.File("pdf");
                com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.File docFile1 = new com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.File("doc");
                com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.File javaFile1 = new com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.File("java");
                com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.File mp3File1 = new com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.File("mp3");

                com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.Folder commonFolder1 = new com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.Folder("commonFolder");
                num1="commonFile num"+"\t"+commonFolder1.add(txtFile1)+"\t"+commonFolder1.add(pdfFile1)+"\t"+commonFolder1.add(docFile1)+"\n";

                com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.Folder codeFolder1 = new com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.Folder("codeFolder");
                num1+="codeFile num"+"\t"+codeFolder1.add(javaFile1)+"\n";

                com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.Folder audioFolder1 = new com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.Folder("musicFolder");
                num1+="musicFile num"+"\t"+audioFolder1.add(mp3File1)+"\n";

                com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.Folder root1 = new com.hjq.examples_of_twelve_design_pattern.Component_Pattern.Safety_type.Folder("root");
                num1+="rootFolder num"+"\t"+root1.add(commonFolder1)+"\t"+root1.add(codeFolder1)+"\t"+root1.add(audioFolder1)+"\n";

                num1+=root1.print("0");

                title.setText("Safety_type");
                textView.setText(num1);
                OringinInit();
                break;
            case 12:
                String string = "";
                ConvertDataToFile convertDataToFile = new ConvertDataToTxtFile(new MysqlDBConnection());
                string = convertDataToFile.getConnection()+"\t"+convertDataToFile.convertToFile()+"\n";

                ConvertDataToFile convertDataToFile1 = new ConvertToPdfFile(new OracleDBConnection());
                string+=convertDataToFile1.getConnection()+"\t"+convertDataToFile1.convertToFile()+"\n";

                title.setText("Bridge_Pattern");
                textView.setText(string);
                OringinInit();
                break;
            case 13:
                String string1 = "";
                for (int i = 0;i<13;i++){
                    Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
                    circle.setX(getRandomX());
                    circle.setY(getRandomY());
                    circle.setRadius(100);
                    string1+=circle.draw()+"\n";
                }

                title.setText("Flyweight_Pattern");
                textView.setText(string1);
                OringinInit();
                break;
        }
    }

    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}
