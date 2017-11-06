package com.example.suzumiya.ltutqc03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user;
    TextView ans,test;
    int i=0;
    int[] ansNum=new int[3];
    int userNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        ansNum=getAnsNum();
    }

    public void enterClick(View view)
    {
        userNum= Integer.parseInt(get());
        int[] userNum2=getUserNum();
        if (checkUserNum(userNum2))
        {
            checkAns(ansNum,userNum2);
        }
        else ans.setText("INPUT:"+userNum2[0]+"輸入錯誤:請輸入三個不同的數字");
    }

    public boolean checkUserNum(int[] userNum)
    {
        boolean a = false;
       if(userNum[2]!=userNum[1])
       {
           if (userNum[1]!=userNum[0])
           {
                a=true;
           }
           else a=false;
       }
       else a=false;
       return a;
    }

    public void checkAns(int[] ansNum,int[] userNum)
    {
        //test.setText("hi");
        int a = 0,b=0;
        for(int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                if(ansNum[i]==userNum[j])
                {
                    if(i==j) a++;
                    else b++;
                }
            }
        }
        if(a==3) ans.setText("INPUT的數字:"+get()+"恭喜你答對囉 答案:"+get());
        else ans.setText("INPUT的數字:"+get()+'='+a+"A"+b+"b");
    }

    public String get()
    {
        return user.getText().toString();
    }

    public int[] getUserNum()
    {
        int num=userNum;
        int[] userNum2=new int[3];
        int c=100;
        for (int i=2;i>=0;i--)
        {
            if(i>0)
            {
                int a=(num-num%c)/c;
                userNum2[i]=a;
                num=num-(a*c);
                c=c/10;
                //test.setText("hi");
            }
            if(i==0)
            {
                userNum2[i]=userNum%10;

                //test.setText("hi");
            }
        }
        return userNum2;
    }

    public int[] getAnsNum()
    {
        ansNum[i]=(int)(Math.random()*10);
        if (i!=0&&ansNum[i-1]==ansNum[i])
        {
            getAnsNum();
        }
        else if(i<2)
        {
            i++;
            getAnsNum();
        }
        return ansNum;
    }

    public void findview()
    {
        user=findViewById(R.id.user);
        ans=findViewById(R.id.ans);
        test=findViewById(R.id.test);
    }
}