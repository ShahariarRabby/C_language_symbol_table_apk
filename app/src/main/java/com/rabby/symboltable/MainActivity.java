package com.rabby.symboltable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    public String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText("");
        editText.setText("int a , b , c ;\n" +
                "float d , e ;\n" +
                "a = b = 5 ;\n" +
                "c = 6 ;\n" +
                "if ( a > b )\n" +
                "{\n" +
                "    c = a - b ;\n" +
                "    e = d - 2.0 ;\n" +
                "}\n" +
                "else\n" +
                "{\n" +
                "    d = e + 6.0 ;\n" +
                "    b = a + c ;\n" +
                "}");
    }


    public void buttonClick(View view) {
            textView.setText("");
            String[] key = {"auto", "break", "case", "char", "const", "continue", "default",
                    "do", "double", "else", "enum", "extern", "float", "for", "goto", "if", "int",
                    "long", "register", "return", "short", "signed", "sizeof", "static", "struct",
                    "switch", "typedef", "union", "unsigned", "void", "volatile", "while"};
            String Math_op[] = {"+", "-", "*", "/", "=", "+=", "-=", "*=", "/=", "%="};

            String Logical[] = {"==", ">", "<", "!=", ">=", "<=", "&&", "||", "!"};

            String Other[] = {",", "{", "}", "(", ")", "[", "]", ";"};

            List<String> listString = new ArrayList<>();
            List<String> listString_Math = new ArrayList<>();
            List<String> listString_Logic = new ArrayList<>();
            List<String> listString_Other = new ArrayList<>();
//        List<String> listString_Others = new ArrayList<>();
//        List<String> listString_Others1 = new ArrayList<>();
//        List<String> listString_Others2 = new ArrayList<>();




            data = editText.getText().toString();
            data = data.replace("\n", " ").replace("\r", " ");
            String[] parts = data.split(" ");
//        int m0 = 0, m1 =0, m2 =0, m3 =0, m4 =0;
            int size = parts.length;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < key.length; j++) {
                    if (parts[i].equals(key[j])) {
                        listString.add(parts[i]);
//                    m0++;
                    }
                }

                for (int k = 0; k < Math_op.length; k++) {
                    if (parts[i].equals(Math_op[k])){
                        listString_Math.add(parts[i]);
//                    m1++;
                    }
                }

                for (int m = 0; m < Logical.length; m++) {
                    if (parts[i].equals(Logical[m])) {
                        listString_Logic.add(parts[i]);
//                    m2++;
                    }
                }

                for (int n = 0; n < Other.length; n++) {
                    if (parts[i].equals(Other[n])) {
                        listString_Other.add(parts[i]);
//                    m3++;
                    }
                }
            }

//        for (int i = 0; i < size; i++) {
//            for (int n = 0; n < m2; n++) {
//                if (parts[i] != listString_Math.get(n)) {
//                    for (int j = 0; j < m1; j++) {
//                        if (parts[i] != listString_Logic.get(j)) {
//                            for (int k = 0; k < m2; k++) {
//                                if (parts[i] != listString_Other.get(k)) {
//                                    textView.append(parts[i]);
//
//                                }
//                            }
//
//                        }
//                    }
//                }
//            }
//        }
//        int m=0;
//        for (int i = 0; i < size; i++) {
//            for (int n = 0; n < m0; n++) {
//                if (parts[i] != listString.get(n)) {
//                    listString_Others.add(parts[i]);
//                    m++;
//                }
//            }
//        }
//        Set<String> setString1 = new HashSet<String>(listString_Others);
//        textView.append("Keyword1: " + setString1);
//        textView.append("\n");
//
//        int mm=0;
//        for (int i = 0; i < m; i++) {
//            for (int n = 0; n < m1; n++) {
//                if (listString_Math.get(n) != listString_Others.get(i)) {
//                    listString_Others1.add(listString_Others.get(i));
//                    mm++;
//                }
//            }
//        }
//        Set<String> setString2 = new HashSet<String>(listString_Others1);
//        textView.append("Keyword2: " + setString2);
//        textView.append("\n");
//        m=0;
//        for (int i = 0; i < mm; i++) {
//            for (int n = 0; n < m2; n++) {
//                if (listString_Logic.get(n) != listString_Others1.get(i)) {
//                    listString_Others2.add(listString_Others1.get(i));
//                    m++;
//                }
//            }
//        }
//        Set<String> setString3 = new HashSet<String>(listString_Others2);
//        textView.append("Keyword3: " + setString3);
//        textView.append("\n");
//        mm=0;
//        List<String> listString_Others3 = new ArrayList<String>();
//        for (int i = 0; i < m; i++) {
//            for (int n = 0; n < m3; n++) {
//                if (listString_Other.get(n) != listString_Others2.get(i)) {
//                    listString_Others3.add(listString_Others2.get(i));
//                    mm++;
//                }
//            }
//        }
//        Set<String> setString4 = new HashSet<>(listString_Others3);
//        textView.append("Keyword4: " + setString4);
//        textView.append("\n");

            Set<String> setString = new HashSet<>(listString);
            textView.append("Keyword: " + setString + "\n");
            Set<String> setString_math = new HashSet<>(listString_Math);
            textView.append("Math Operators: " + setString_math + "\n");
            Set<String> setString_logic = new HashSet<>(listString_Logic);
            textView.append("Logical Operators: " + setString_logic + "\n");
            Set<String> setString_other = new HashSet<>(listString_Other);
            textView.append("Other Operators: " + setString_other + "\n");
            textView.append("Numerical Values need to code \n");
            textView.append("Others Values need to code \n");


    }

    public void reset(View view) {
        editText.setText("");
        textView.setText("Input code to see symbol table.");
    }
}
