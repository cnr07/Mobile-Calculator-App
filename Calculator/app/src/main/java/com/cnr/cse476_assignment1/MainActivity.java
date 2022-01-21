package com.cnr.cse476_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    TextView OperationsTV;
    TextView ResultTV;

    String operations = "";

    boolean isPointCome=false;
    boolean isClear=true;
    int isEqualPressed=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OperationsTV=(TextView)findViewById(R.id.OperationsTextView);
        ResultTV=(TextView)findViewById(R.id.ResultTextView);
    }

    public void setOperations(String op){
        operations+=op;
        OperationsTV.setText(operations);
    }

    public void Clear(View view) {
        OperationsTV.setText("");ResultTV.setText("");
        operations="";isClear=true;isPointCome=false;
    }

    public void Equal(View view) {
        int isStartMinus=0;
        if(operations.startsWith("-")){isStartMinus=1;}
        if(operations.endsWith("-")||operations.endsWith("+")||operations.endsWith("/")||operations.endsWith("X")){
            operations="NaN";
        }
        else{
            for(int i=0;i<operations.length();i++){

                if(operations.charAt(i)=='X' ){
                    double left=0,right=0;String s1="";String s2="";double minitotal=0;String changepart="";
                    String newpartString="";
                    for(int x=i+1;x<operations.length();x++){//r
                        if(operations.charAt(x)!='+'&& operations.charAt(x)!='-' && operations.charAt(x)!='X'&&operations.charAt(x)!='/'){
                            s1+=operations.charAt(x);
                        }
                        else{
                            break;
                        }
                    }
                    for(int y=i-1;y>=0;y--){//l
                        if(operations.charAt(y)!='+'&& operations.charAt(y)!='-' && operations.charAt(y)!='X'&&operations.charAt(y)!='/'){
                            s2+=operations.charAt(y);
                        }
                        else{
                            break;
                        }
                    }
                    StringBuilder forleft = new StringBuilder(s2);
                    s2 = forleft.reverse().toString();
                    left=Double.parseDouble(s2);
                    right=Double.parseDouble(s1);
                    System.out.println(left+"SOLLL");
                    System.out.println(right+"SAĞĞĞĞ");
                    minitotal=left*right;System.out.println(minitotal+"MİNİTOTAl");
                    String star="X";
                    changepart=s2+star+s1;
                    System.out.println(changepart+"changePART");
                    newpartString=Double.toString(minitotal);
                    System.out.println(newpartString+"NewPartString");
                    String fakeOP=operations.replaceAll(changepart,newpartString);
                    System.out.println(fakeOP+"FAKEOP");
                    operations=fakeOP;
                }
            }
            //////////////////////
            for(int i=0;i<operations.length();i++){

                if(operations.charAt(i)=='/' && i!=0){
                    double left=0,right=0;String s1="";String s2="";double minitotal=0;String changepart="";
                    String newpartString="";
                    for(int x=i+1;x<operations.length();x++){//r
                        if(operations.charAt(x)!='+'&& operations.charAt(x)!='-' && operations.charAt(x)!='X'&&operations.charAt(x)!='/'){
                            s1+=operations.charAt(x);
                        }
                        else{
                            break;
                        }
                    }
                    for(int y=i-1;y>=0;y--){//l
                        if(operations.charAt(y)!='+'&& operations.charAt(y)!='-' && operations.charAt(y)!='X'&&operations.charAt(y)!='/'){
                            s2+=operations.charAt(y);
                        }
                        else{
                            break;
                        }
                    }
                    StringBuilder forleft = new StringBuilder(s2);
                    s2 = forleft.reverse().toString();
                    left=Double.parseDouble(s2);
                    right=Double.parseDouble(s1);
                    System.out.println(left+"SOLLL");
                    System.out.println(right+"SAĞĞĞĞ");
                    minitotal=left/right;System.out.println(minitotal+"MİNİTOTAl");
                    String star="/";
                    changepart=s2+star+s1;
                    System.out.println(changepart+"changePART");
                    newpartString=Double.toString(minitotal);
                    System.out.println(newpartString+"NewPartString");
                    String fakeOP=operations.replaceAll(changepart,newpartString);
                    System.out.println(fakeOP+"FAKEOP");
                    operations=fakeOP;
                }
            }
            //////////////////////
            for(int i=0;i<operations.length();i++){
                int ig=i;
                if(operations.charAt(i)=='-' && i!=0){
                    double left=0,right=0;String s1="";String s2="";double minitotal=0;String changepart="";
                    String newpartString="";int y=0;
                    for(int x=i+1;x<operations.length();x++){//r
                        if(operations.charAt(x)!='+'&& operations.charAt(x)!='-' && operations.charAt(x)!='X'&&operations.charAt(x)!='/'){
                            s1+=operations.charAt(x);
                        }
                        else{
                            if (i==0){
                                //s1 sol
                                y=x+1;
                            }
                            else{y=i-1;}
                            break;
                        }
                    }

                    for(y=i-1;y>=0;y--){//l
                        if(operations.charAt(y)!='+'&& operations.charAt(y)!='-' && operations.charAt(y)!='X'&&operations.charAt(y)!='/'){
                            s2+=operations.charAt(y);
                        }
                        else{
                            break;
                        }
                    }
                    /*if(isStartMinus==1){System.out.println(":REWREW:REW:REW");
                        StringBuilder forleft = new StringBuilder(s1);
                        s1 = forleft.reverse().toString();
                        left=Double.parseDouble(s1);
                        right=Double.parseDouble(s2);
                    }*/

                        StringBuilder forleft = new StringBuilder(s2);
                        s2 = forleft.reverse().toString();
                        left=Double.parseDouble(s2);
                        right=Double.parseDouble(s1);
                        if(isStartMinus==1){left*=-1;}


                    System.out.println(left+"SOLLL");
                    System.out.println(right+"SAĞĞĞĞ");
                    if(i==0){
                        minitotal=-left-right;System.out.println(minitotal+"MİNİTOTAl");
                        String star="-";
                        changepart="-"+s1+star+s2;
                        System.out.println(changepart+"changePART");
                        newpartString=Double.toString(minitotal);
                        System.out.println(newpartString+"NewPartString");
                        String fakeOP=operations.replaceAll(changepart,newpartString);
                        System.out.println(fakeOP+"FAKEOP");
                        operations=fakeOP;
                    }
                    else{
                        minitotal=left-right;System.out.println(minitotal+"MİNİTOTAl");
                        String star="-";
                        changepart=s2+star+s1;
                        System.out.println(changepart+"changePART");
                        newpartString=Double.toString(minitotal);
                        System.out.println(newpartString+"NewPartString");
                        String fakeOP=operations.replaceAll(changepart,newpartString);
                        System.out.println(fakeOP+"FAKEOP");
                        operations=fakeOP;
                    }

                }
            }
            /////////////////////////
            for(int i=0;i<operations.length();i++){

                if(operations.charAt(i)=='+' && i!=0){
                    double left=0,right=0;String s1="";String s2="";double minitotal=0;String changepart="";
                    String newpartString="";
                    for(int x=i+1;x<operations.length();x++){//r
                        if(operations.charAt(x)!='+'&& operations.charAt(x)!='-' && operations.charAt(x)!='X'&&operations.charAt(x)!='/'){
                            s1+=operations.charAt(x);
                        }
                        else{
                            break;
                        }
                    }
                    for(int y=i-1;y>=0;y--){//l
                        if(operations.charAt(y)!='+'&& operations.charAt(y)!='-' && operations.charAt(y)!='X'&&operations.charAt(y)!='/'){
                            s2+=operations.charAt(y);
                        }
                        else{
                            break;
                        }
                    }
                    StringBuilder forleft = new StringBuilder(s2);
                    s2 = forleft.reverse().toString();
                    left=Double.parseDouble(s2);
                    right=Double.parseDouble(s1);
                    if(isStartMinus==1){left*=-1;}
                    System.out.println(left+"SOLLL");
                    System.out.println(right+"SAĞĞĞĞ");
                    minitotal=left+right;System.out.println(minitotal+"MİNİTOTAl");
                    String star="\\+";
                    changepart=s2+star+s1;
                    System.out.println(changepart+"changePART");
                    newpartString=Double.toString(minitotal);
                    System.out.println(newpartString+"NewPartString");
                    String fakeOP=operations.replaceAll(changepart,newpartString);
                    System.out.println(fakeOP+"FAKEOP");
                    operations=fakeOP;
                }
            }
        }







        if(operations.equals("-Infinity")||operations.equals("Infinity")){operations="NaN";}
        if(operations.contains("--")){String s1=operations.replaceAll("--","-");operations=s1;}
        if(operations.contains("-0.0")){String s1=operations.replaceAll("-0.0","0.0");operations=s1;}
        ResultTV.setText(operations);
        if(operations=="NaN"){operations="";}isEqualPressed=1;operations="";
    }


    public void Division(View view) {
        if(operations.endsWith("0")||operations.endsWith("1")||operations.endsWith("2")||operations.endsWith("3")||operations.endsWith("4")||operations.endsWith("5")||operations.endsWith("6")||operations.endsWith("7")||operations.endsWith("8")||operations.endsWith("9")){
            setOperations("/");isPointCome=false;isClear=false;
        }

    }

    public void Seven(View view) {


            setOperations("7");isClear=false;


    }

    public void Eight(View view) {


            setOperations("8");isClear=false;


    }

    public void Nine(View view) {


            setOperations("9");isClear=false;


    }

    public void Multiply(View view) {
        if(operations.endsWith("0")||operations.endsWith("1")||operations.endsWith("2")||operations.endsWith("3")||operations.endsWith("4")||operations.endsWith("5")||operations.endsWith("6")||operations.endsWith("7")||operations.endsWith("8")||operations.endsWith("9")){
            setOperations("X");isPointCome=false;isClear=false;
        }
    }

    public void Four(View view) {


            setOperations("4");isClear=false;


    }

    public void Five(View view) {


            setOperations("5");isClear=false;


    }

    public void Six(View view) {


            setOperations("6");isClear=false;


    }

    public void Minus(View view) {
        if(operations.endsWith("0")||operations.endsWith("1")||operations.endsWith("2")||operations.endsWith("3")||operations.endsWith("4")||operations.endsWith("5")||operations.endsWith("6")||operations.endsWith("7")||operations.endsWith("8")||operations.endsWith("9")){
            setOperations("-");isPointCome=false;isClear=false;
        }
        else if(isClear){
            setOperations("-");isPointCome=false;isClear=false;
        }
    }

    public void One(View view) {


            setOperations("1");isClear=false;


    }

    public void Two(View view) {


            setOperations("2");isClear=false;


    }

    public void Three(View view) {


            setOperations("3");isClear=false;


    }

    public void Plus(View view) {
        if(operations.endsWith("0")||operations.endsWith("1")||operations.endsWith("2")||operations.endsWith("3")||operations.endsWith("4")||operations.endsWith("5")||operations.endsWith("6")||operations.endsWith("7")||operations.endsWith("8")||operations.endsWith("9")){
            setOperations("+");isPointCome=false;isClear=false;
        }
    }

    public void Point(View view) {
        if(isPointCome==false){
            if(operations.endsWith("0")||operations.endsWith("1")||operations.endsWith("2")||operations.endsWith("3")||operations.endsWith("4")||operations.endsWith("5")||operations.endsWith("6")||operations.endsWith("7")||operations.endsWith("8")||operations.endsWith("9")){
                setOperations(".");isPointCome=true;isClear=false;
            }
        }
    }

    public void Zero(View view) {


            setOperations("0");isClear=false;
        

    }

    public void Delete(View view) {
        if(operations.length()>=1){
            operations=operations.substring(0,operations.length()-1);
            OperationsTV.setText(operations);
        }
        if(operations.length()==0){
            isClear=true;
        }

    }



    public void E_value(View view) {
        if(isPointCome==false){
            if(operations.endsWith("0")||operations.endsWith("1")||operations.endsWith("2")||operations.endsWith("3")||operations.endsWith("4")||operations.endsWith("5")||operations.endsWith("6")||operations.endsWith("7")||operations.endsWith("8")||operations.endsWith("9")){
                setOperations("X2.71");isPointCome=true;isClear=false;
            }
            else{
                setOperations("2.71");isPointCome=true;isClear=false;
            }

        }
        else{
            if(operations.endsWith("0")||operations.endsWith("1")||operations.endsWith("2")||operations.endsWith("3")||operations.endsWith("4")||operations.endsWith("5")||operations.endsWith("6")||operations.endsWith("7")||operations.endsWith("8")||operations.endsWith("9")){
                setOperations("X2.71");isPointCome=true;isClear=false;
            }

        }

    }

    public void Pi_value(View view) {
        if(isPointCome==false){
            if(operations.endsWith("0")||operations.endsWith("1")||operations.endsWith("2")||operations.endsWith("3")||operations.endsWith("4")||operations.endsWith("5")||operations.endsWith("6")||operations.endsWith("7")||operations.endsWith("8")||operations.endsWith("9")){
                setOperations("X3.14");isPointCome=true;isClear=false;
            }
            else{
                setOperations("3.14");isPointCome=true;isClear=false;
            }
        }
        else{
            if(operations.endsWith("0")||operations.endsWith("1")||operations.endsWith("2")||operations.endsWith("3")||operations.endsWith("4")||operations.endsWith("5")||operations.endsWith("6")||operations.endsWith("7")||operations.endsWith("8")||operations.endsWith("9")){
                setOperations("X3.14");isPointCome=true;isClear=false;
            }

        }

    }


}