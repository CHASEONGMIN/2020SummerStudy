package com.example.k_dm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity; 
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText; 
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends Activity{

    ListView listView1;
    ListView listView2;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2; 
    ArrayList<String> listItem;
    ArrayList<String> listItem2;

    ImageView am9;
    ImageView pm12;
    ImageView pm18;
    private Context mContext;
    public static Context Context;

    EditText editText1;
    Button button1;
    ImageButton button2;

    TextView textW;
    TextView textH;
    TextView textS;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    String[] jbm;
    String textcp;

    String key = "jTnzyCPieEVWSxqtlgHjvk37q3aHGkttzcMNDxADJCB7aLPPjhexcI0EIgl%2BMNU1PBFXdkrjpPh79VwopMs7EA%3D%3D&";

    String data;
    ArrayList<String> data2;
    String data3;
    String val;

    String homesi;
    String homegun;
    String compsi;
    String compgun;

    String yeok;
    String hang;
    String gisa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dan Morning");
        mContext = this;
        Context = this;
        ArrayAdapter<String> Adapter4;


        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println("아1");
        System.out.println(sdf);
        System.out.println("아2");
        System.out.println("아3");
        final String getTime = sdf.format(date);
        System.out.println(getTime);
        System.out.println("아4");
        String homesi1= shared.getString(Context, "homesi");
        String homegun1= shared.getString(Context, "homegun");
        String compsi= shared.getString(Context, "compsi");
        final String compgun= shared.getString(Context, "compgun");

        final String yeok= shared.getString(Context, "yeok");
        String hang= shared.getString(Context, "hang");

        String text = shared.getString(mContext, "rebuild");
        textcp=text;

        editText1 = findViewById(R.id.editText1);
        button1 = findViewById(R.id.button1);

        jbm = text.split(" ");


        listItem = new ArrayList<String>();
        listItem2 = new ArrayList<String>();
        //for (int k = 0 ; k<jbm.length ; k++){
        //    listItem.add(jbm[k]);
        //}
        for (int i=0 ; i<jbm.length ; i++){
            if (jbm.length==0){
                ;
            }
            listItem.add(jbm[i]);
        }


        am9 = (ImageView)findViewById(R.id.imageView1);
        pm12 = (ImageView)findViewById(R.id.imageView2);
        pm18 = (ImageView)findViewById(R.id.imageView3);
        button2 = findViewById(R.id.imageView8);


        textW = (TextView) findViewById(R.id.text);
        textH = (TextView) findViewById(R.id.text2);
        textS = (TextView) findViewById(R.id.station);
        text1 = (TextView) findViewById(R.id.hd);
        text2 = (TextView) findViewById(R.id.hd2);
        text3 = (TextView) findViewById(R.id.hd3);
        text4 = (TextView) findViewById(R.id.hd4);
        text5 = (TextView) findViewById(R.id.hd5);

        textS.setText(yeok+hang);

        homesi=shared.getString(Context, "homesi");
        homegun=shared.getString(Context, "homegun");

        System.out.println(homesi + homegun);

        textH.setText(compsi +" "+compgun);


        // 아이템 추가한다.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val = editText1.getText().toString();
                listItem.add(val);
                String text3 = shared.getString(mContext, "rebuild");
                //val=(listItem.get(listItem.size() - 1)+"\n");
                shared.setString(mContext, "rebuild", text3+val+" ");
                adapter.notifyDataSetChanged(); // 변경되었음을 어답터에 알려준다.
                editText1.setText("");


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), setting.class);
                startActivity(intent);

            }
        });


        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listItem);
        listView1 = findViewById(R.id.listView1);
        listView1.setAdapter(adapter);

        // 각 아이템 클릭시 해당 아이템 삭제한다.
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 콜백매개변수는 순서대로 어댑터뷰, 해당 아이템의 뷰, 클릭한 순번, 항목의 아이디
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), listItem.get(i).toString() + " 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                String text3 = shared.getString(mContext, "rebuild");
                String text6=text3.replace(listItem.get(i).toString()+" ","");
                shared.setString(mContext, "rebuild", text6);
                listItem.remove(i);
                adapter.notifyDataSetChanged();
            }
        });

        new Thread(new Runnable() {

            @Override
            public void run() {
                String compgun1=compgun;
                // TODO Auto-generated method stub
                data = getXmlData(compgun1, getTime);//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                System.out.println("처음에서나온데이텋");
                System.out.println(data);
                System.out.println("처음에서나온데이텋");
                data2 = getTextt();

                //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        char [] picdata=wp(data);
                        if (picdata[0]=='s'){
                            am9.setImageResource(R.drawable.sunny);
                        }
                        else if (picdata[0]=='r'){
                            am9.setImageResource(R.drawable.rain);
                        }
                        else if (picdata[0]=='d'){
                            am9.setImageResource(R.drawable.cloud);
                        }
                        else if (picdata[0]=='n'){
                            am9.setImageResource(R.drawable.snow);
                        }
                        else if (picdata[0]=='c'){
                            am9.setImageResource(R.drawable.littlecloud);
                        }
                        else ;

                        if (picdata[1]=='s'){
                            pm12.setImageResource(R.drawable.sunny);
                        }
                        else if (picdata[1]=='r'){
                            pm12.setImageResource(R.drawable.rain);
                        }
                        else if (picdata[1]=='d'){
                            pm12.setImageResource(R.drawable.cloud);
                        }
                        else if (picdata[1]=='n'){
                            pm12.setImageResource(R.drawable.snow);
                        }
                        else if (picdata[1]=='c'){
                            pm12.setImageResource(R.drawable.littlecloud);
                        }
                        else ;

                        if (picdata[2]=='s'){
                            pm18.setImageResource(R.drawable.sunny);
                        }
                        else if (picdata[2]=='r'){
                            pm18.setImageResource(R.drawable.rain);
                        }
                        else if (picdata[2]=='d'){
                            pm18.setImageResource(R.drawable.cloud);
                        }
                        else if (picdata[2]=='n'){
                            pm18.setImageResource(R.drawable.snow);
                        }
                        else if (picdata[2]=='c'){
                            pm18.setImageResource(R.drawable.littlecloud);
                        }
                        else ;
                    }
                });
            }

        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                data2 = getTextt();
                gisa=data2.toString();

                //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gisa=data2.toString();
                        text1.setText(data2.get(0));
                        text2.setText(data2.get(1));
                        text3.setText(data2.get(2));
                        text4.setText(data2.get(3));
                        text5.setText(data2.get(4));
                        // TODO Auto-generated method stub
                        //textW.setText(data2); //TextView에 문자열  data 출력
                    }
                });
            }

        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                data3 = getXmlData3(yeok);

                //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(data3);
                        String data5=data3.replace("상행","");
                        String data6=data5.replace("하행","");
                        String [] data4;
                        data4 = data6.split("\\n");
                        for (int i=0 ; i<data4.length ; i++){
                            listItem2.add(data4[i]);
                        }
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listItem2);
                        listView2 = findViewById(R.id.listView4);
                        listView2.setAdapter(adapter2);


                        // TODO Auto-generated method stub
                        //textW.setText(data2); //TextView에 문자열  data 출력
                    }
                });
            }

        }).start();



    }



    String getXmlData(String X, String T) {
        String x="1";
        String y="1";
        System.out.println(X);

        if (X.equals("도봉구") || X.equals("강북구")|| X.equals("노원구")){
            x="61";
            y="128";
            System.out.println("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
            System.out.println("도봉강북노원");
            System.out.println("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
        }
        else if(X.equals("성북구")|| X.equals("동대문구")|| X.equals("중랑구")){
            x="61";
            y="126";
        }
        else if(X.equals("은평구")|| X.equals("서대문구")){
            x="59";
            y="127";
        }
        else if(X.equals("종로구")|| X.equals("중구")){
            x="60";
            y="127";
            System.out.println("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
            System.out.println("종로중");
            System.out.println("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
        }
        else if(X.equals("마포구")|| X.equals("용산구")){
            x="60";
            y="126";
        }
        else if(X.equals("성동구")|| X.equals("광진구")){
            x="61";
            y="127";
        }
        else if(X.equals("강서구")|| X.equals("양천구")||X.equals("구로구")){
            x="57";
            y="126";
        }
        else if(X.equals("영등포구")|| X.equals("동작구")){
            x="59";
            y="125";
        }
        else if(X.equals("금천구")|| X.equals("관악구")){
            x="60";
            y="125";
        }
        else if(X.equals("서초구")|| X.equals("강남구")){
            x="61";
            y="125";
        }
        else if(X.equals("송파구")|| X.equals("강동구")){
            x="62";
            y="125";
        }
        //인천
        else if(X.equals("서구")|| X.equals("계양구")||X.equals("부평구")){
            x="55";
            y="125";
        }
        else if(X.equals("동구")|| X.equals("중구")||X.equals("미추홀구")){
            x="55";
            y="124";
        }
        else if(X.equals("연수구")){
            x="55";
            y="123";
        }
        else if(X.equals("남동구")){
            x="56";
            y="124";
        }
        else if(X.equals("강화군")){
            x="50";
            y="130";
        }


        else if(X.equals("연천군")||X.equals("동두천시")||X.equals("포천시")){
            x="60";
            y="137";
        }
        else if(X.equals("김포시")||X.equals("파주시")||X.equals("고양시")){
            x="56";
            y="130";
        }
        else if(X.equals("부천시")||X.equals("시흥시")||X.equals("안산시")){
            x="57";
            y="123";
        }
        else if(X.equals("화성시")||X.equals("오산시")||X.equals("평택시")){
            x="60";
            y="119";
        }
        else if(X.equals("남양주시")||X.equals("구리시")||X.equals("가평군")||X.equals("하남시")){
            x="67";
            y="131";
        }
        else if(X.equals("광주시")||X.equals("양평군")||X.equals("여주시")||X.equals("이천시")){
            x="72";
            y="127";
        }
        else if(X.equals("양주시")||X.equals("의정부시")){
            x="61";
            y="131";
        }
        else if(X.equals("의왕시")||X.equals("수원시")){
            x="60";
            y="123";
        }
        else if(X.equals("성남시")){
            x="63";
            y="122";
        }
        else if(X.equals("용인시")){
            x="62";
            y="121";
        }
        else if(X.equals("안성시")){
            //x="64";
            //y="114";
            x="65";
            y="127";
        }
        else;





        StringBuffer buffer = new StringBuffer();


        //String queryUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=jTnzyCPieEVWSxqtlgHjvk37q3aHGkttzcMNDxADJCB7aLPPjhexcI0EIgl%2BMNU1PBFXdkrjpPh79VwopMs7EA%3D%3D&pageNo=1&numOfRows=40&dataType=XML&base_date=20200614&base_time=0500&nx=1&ny=1&";

        String queryUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=jTnzyCPieEVWSxqtlgHjvk37q3aHGkttzcMNDxADJCB7aLPPjhexcI0EIgl%2BMNU1PBFXdkrjpPh79VwopMs7EA%3D%3D&pageNo=1&numOfRows=40&dataType=XML&base_date="+T+"&base_time=0500&nx="+x+"&ny="+y+"&";
        System.out.println(queryUrl);
        try {
            URL url = new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is = url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8")); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();//태그 이름 얻어오기

                        if (tag.equals("item")) ;// 첫번째 검색결과
                        else if (tag.equals("category")) {
                            xpp.next();
                            buffer.append(xpp.getText());//cpId
                            //buffer.append("\n");
                        } else if (tag.equals("fcstValue")) {
                            xpp.next();
                            buffer.append(xpp.getText());//cpId
                            //buffer.append("\n");
                        } else if (tag.equals("fcstTime")) {
                            xpp.next();
                            buffer.append(xpp.getText());
                            //buffer.append("\n");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName(); //태그 이름 얻어오기

                        if (tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈

                        break;
                }

                eventType = xpp.next();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }

        return buffer.toString();//StringBuffer 문자열 객체 반환

    }

    public ArrayList<String> getTextt(){
        ArrayList<String> Headline = new ArrayList<String>();
        try{
            //////// xml 문서를 파싱하기위한 준비
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
//////// xml 웹 문서를 Document객체로 만드는 과정
            String url= "http://rss.hankyung.com/new/news_intl.xml"; // 주소
            URL nURL = new URL(url);
            InputStream xml = nURL.openStream();
            Document doc = builder.parse(xml);

            //////// 엘리먼트 접근
            Element root = doc.getDocumentElement(); // 루트 엘리먼트
            // item이란 이름을 가진 모든 요소를 찾는다.
            NodeList items = root.getElementsByTagName("item");
            for(int i=0;i<items.getLength();i++){ // 찾은 갯수만큼 루프
                Node item = items.item(i); // 하나의 item요소 접근
                // item요소의 두번째 자식요소 title 접근(첫번째 자식은 텍스트 노드)
                Node title = item.getFirstChild().getNextSibling();
                Node value = title.getFirstChild(); // title 요소의 내용 접근
                Headline.add(value.getNodeValue()+"\n"); // 내용을 Arraylist에 삽입
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(Headline.get(0));
        System.out.println(Headline.get(1));
        System.out.println(Headline.get(2));
        return Headline;
    }

    String getXmlData3(String Y) {

        //Y=method(Y);


        StringBuffer buffer = new StringBuffer();


        //String queryUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=jTnzyCPieEVWSxqtlgHjvk37q3aHGkttzcMNDxADJCB7aLPPjhexcI0EIgl%2BMNU1PBFXdkrjpPh79VwopMs7EA%3D%3D&pageNo=1&numOfRows=40&dataType=XML&base_date=20200614&base_time=0500&nx=1&ny=1&";

        String queryUrl = "http://swopenapi.seoul.go.kr/api/subway/7463466a5170696e34314d6e575746/xml/realtimeStationArrival/0/20/"+Y;
        try {
            URL url = new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is = url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8")); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();//태그 이름 얻어오기

                        if (tag.equals("row")) ;// 첫번째 검색결과
                        else if (tag.equals("updnLine")) {
                            xpp.next();
                            buffer.append(xpp.getText());//cpId
                            //buffer.append("\n");
                        }else if (tag.equals("trainLineNm")) {
                            xpp.next();
                            buffer.append(xpp.getText()+" : ");//cpId
                        }
                        else if (tag.equals("arvlMsg2")) {
                            xpp.next();
                            buffer.append(xpp.getText());//cpId
                            buffer.append("\n");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName(); //태그 이름 얻어오기

                        if (tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈

                        break;
                }

                eventType = xpp.next();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }
        System.out.println(buffer.toString());

        return buffer.toString();//StringBuffer 문자열 객체 반환

    }

    public String method(String str) {
        if (str.length() > 0 && str.charAt(str.length()-1)=='x') {
            str = str.substring(0, str.length()-1);
        }
        return str;
    }

    String[] stringF(String data) {
        String[] str1 = new String[50];
        String[] change_target;
        change_target = data.split("\\n");
        ;
        //change_target= data3.split("\\n");

        int j = 0;
        for (int i = 0; i < change_target.length; i++) {
            if (change_target[i].contains("PTY")) {
                str1[j] = change_target[i];
                j++;
            } else if (change_target[i].contains("SKY")) {
                str1[j] = change_target[i];
                j++;
            } else if (change_target[i].contains("T3H")) {
                str1[j] = change_target[i];
                j++;
            } else ;
        }
        return str1; //여기하자@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@왜 리턴이 안돼는지
    }

    public char[] wp(String data2) {
        String[] dataP;
        dataP = stringF(data2);
        char[] ret = new char[3];

        if (dataP[0].endsWith("0")) {
            if (dataP[1].endsWith("1")) {//맑음
                ret[0] = 's';
            } else if (dataP[1].endsWith("3")) {//구름조금
                ret[0] = 'c';
            } else if (dataP[1].endsWith("4")) {//구름많음
                ret[0] = 'd';
            }
        } else if (dataP[0].endsWith("1") || dataP[0].endsWith("2") || dataP[0].endsWith("4")) {
            ret[0] = 'r';
        } else if (dataP[0].endsWith("3")) {
            ret[0] = 'n';
        }

        if (dataP[3].endsWith("0")) {
            if (dataP[4].endsWith("1")) {//맑음
                ret[1] = 's';
            } else if (dataP[4].endsWith("3")) {//구름조금
                ret[1] = 'c';
            } else if (dataP[4].endsWith("4")) {//구름많음
                ret[1] = 'd';
            }
        } else if (dataP[3].endsWith("1") || dataP[3].endsWith("2") || dataP[3].endsWith("4")) {
            ret[1] = 'r';
        } else if (dataP[3].endsWith("3")) {
            ret[1] = 'n';
        }

        if (dataP[9].endsWith("0")) {
            if (dataP[10].endsWith("1")) {//맑음
                ret[2] = 's';
            } else if (dataP[10].endsWith("3")) {//구름조금
                ret[2] = 'c';
            } else if (dataP[10].endsWith("4")) {//구름많음
                ret[2] = 'd';
            }
        } else if (dataP[9].endsWith("1") || dataP[9].endsWith("2") || dataP[9].endsWith("4")) {
            ret[2] = 'r';
        } else if (dataP[9].endsWith("3")) {
            ret[2] = 'n';
        }

        return ret;

    }

}






