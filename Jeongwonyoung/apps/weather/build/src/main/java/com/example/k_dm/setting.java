package com.example.k_dm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class setting extends Activity {
    ArrayAdapter<CharSequence> adspin1, adspin2, adspin3, adspin4, adspin5, adspin6, adspin7; //어댑터를 선언
    String choice_do = "";
    String choice_se = "";//검색시 선택된 메세지 
    String hosun = "";
    String yeok = "";
    String hang = "";
    ArrayAdapter<String> adapterZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_preference);
        final Spinner spin1 = (Spinner) findViewById(R.id.spinner);
        final Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spin3 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spin4 = (Spinner) findViewById(R.id.spinner21);
        final Spinner spin5 = (Spinner) findViewById(R.id.spinnerG);
        final Spinner spin6 = (Spinner) findViewById(R.id.spinnerG2);
        final Spinner spin7 = (Spinner) findViewById(R.id.spinnerG3);


        Button btn_refresh = (Button) findViewById(R.id.btn_refresh);
        Button btn_refresh2 = (Button) findViewById(R.id.btn_refresh2);//xml과 class에 변수들 연결
        Button btn_refresh3 = (Button) findViewById(R.id.btn_refresh3);
        adspin1 = ArrayAdapter.createFromResource(this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
        adspin3 = ArrayAdapter.createFromResource(this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
        adspin5 = ArrayAdapter.createFromResource(this, R.array.train, android.R.layout.simple_spinner_dropdown_item);//첫번째 어댑터에 값을 넣습니다. this=현재class/ 로 String값들을 선언해두었습니다. 
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adspin1);
        adspin3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(adspin3);
        adspin5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin5.setAdapter(adspin5);
//어댑터에 값들을 spinner에 넣습니다. 여기까지 하시면 첫번째 spinner에 값들이 들어감
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//첫번째 spinner 클릭시 이벤트 발생
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) 
                if (adspin1.getItem(i).equals("서울특별시")) {//클릭 한것이 서울인지 확인합니다.
                    choice_do = "서울특별시";//버튼 클릭시 출력을 위해 값
                    adspin2 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_seoul, android.R.layout.simple_spinner_dropdown_item);//서울일 경우에 두번째 spinner에 값을 넣습니다.
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);//두번째 어댑터값을 두번째 spinner에 
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//이안에 두번째 spinner 선택 이벤트를 정의합니다.
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();//두번째 선택된 값을 choice_se에 
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {//아무것도 선택안될시 부분. 자동완성
                        }
                    });
                } else if (adspin1.getItem(i).equals("인천광역시")) {//똑같은 소스에 반복- 인천부분.
                    choice_do = "인천광역시";
                    adspin2 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_incheon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("경기도")) {//똑같은 소스에 반복. 인천부분
                    choice_do = "경기도";
                    adspin2 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_gg, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_refresh.setOnClickListener(new View.OnClickListener() {//버튼 클릭시 이벤트
            @Override
            public void onClick(View view) {
                Toast.makeText(setting.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                ((MainActivity) MainActivity.Context).homesi = choice_do;
                shared.setString(MainActivity.Context, "homesi", choice_do);
                ((MainActivity) MainActivity.Context).homegun = choice_se;
                shared.setString(MainActivity.Context, "homegun", choice_se);
            }
        });


        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//첫번째 spinner 클릭시 이벤트 발생. setO 정도까지 치시면 자동완성됩니다. 뒤에도 마찬가지입니다.
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {//제대로 자동완성하셨다면 이부분이 자동으로 만들어 질 것입니다. int i는 포지션이라 하여 제가 spinner에 몇번째걸 선택했는지 값이 들어갑니다. 필요하겠죠? ㅎㅎ
                if (adspin3.getItem(i).equals("서울특별시")) {//spinner에 값을 가져와서 i 보이시나요 제가 클릭 한것이 서울인지 확인합니다.
                    choice_do = "서울특별시";//버튼 클릭시 출력을 위해 값을 넣었습니다.
                    adspin4 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_seoul, android.R.layout.simple_spinner_dropdown_item);//서울일 경우에 두번째 spinner에 값을 넣습니다. //그냥 this가 아닌 Main~~~인 이유는 그냥 this는 메인엑티비티인 경우만 가능합니다. //지금과 같이 다른 함수안이나 다른 클래스에서는 꼭 자신의 것을 넣어주어야 합니다.//혹시나 다른 class -> Public View밑에서 작업하시는 분은 view명.getContext()로 해주셔야 합니다.//예로 View rootView =~~ 선언하신 경우에는 rootView.getContext()써주셔야합니다. this가 아니라요.
                    adspin4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin4.setAdapter(adspin4);//두번째 어댑터값을 두번째 spinner에 넣었습니다.
                    spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//저희는 두번째 선택된 값도 필요하니 이안에 두번째 spinner 선택 이벤트를 정의합니다.
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin4.getItem(i).toString();//두번째 선택된 값을 choice_se에 넣습니다.
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {//아무것도 선택안될시 부분입니다. 자동완성됩니다.
                        }
                    });
                } else if (adspin3.getItem(i).equals("인천광역시")) {//똑같은 소스에 반복입니다. 인천부분입니다.
                    choice_do = "인천광역시";
                    adspin4 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_incheon, android.R.layout.simple_spinner_dropdown_item);
                    adspin4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin4.setAdapter(adspin4);
                    spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin4.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin3.getItem(i).equals("경기도")) {//똑같은 소스에 반복입니다. 인천부분입니다.
                    choice_do = "경기도";
                    adspin4 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_gg, android.R.layout.simple_spinner_dropdown_item);
                    adspin4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin4.setAdapter(adspin4);
                    spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin4.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_refresh2.setOnClickListener(new View.OnClickListener() {//버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {

                Toast.makeText(setting.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                ((MainActivity) MainActivity.Context).compsi = choice_do;
                System.out.println(choice_do + choice_se);
                ((MainActivity) MainActivity.Context).compgun = choice_se;
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        long now = System.currentTimeMillis();
                        Date date = new Date(now);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                        final String getTime = sdf.format(date);
                        ((MainActivity) MainActivity.Context).data = ((MainActivity) MainActivity.Context).getXmlData(((MainActivity) MainActivity.Context).compgun, getTime);//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기

                        //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                        //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                    }

                }).start();

            }

        });

        /////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////


        spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adspin5.getItem(i).equals("1호선")) {
                    hosun = "1호선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_1, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("2호선")) {
                    hosun = "2호선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_2, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }

                ////////여기부터 3호선 쭈욱
                else if (adspin5.getItem(i).equals("3호선")) {
                    hosun = "3호선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_3, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("4호선")) {
                    hosun = "4호선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_4, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("5호선")) {
                    hosun = "5호선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_5, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("6호선")) {
                    hosun = "6호선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_6, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("7호선")) {
                    hosun = "7호선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_7, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("8호선")) {
                    hosun = "8호선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_8, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("9호선")) {
                    hosun = "9호선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_9, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("분당선")) {
                    hosun = "분당선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_b, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("신분당선")) {
                    hosun = "신분당선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_sb, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("경의선")) {
                    hosun = "경의선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_g, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("중앙선")) {
                    hosun = "중앙선";
                    adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_j, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_refresh3.setOnClickListener(new View.OnClickListener() {//버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                Toast.makeText(setting.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                ((MainActivity) MainActivity.Context).textS.setText(yeok);
                shared.setString(((MainActivity) MainActivity.Context).Context, "yeok", ((MainActivity) MainActivity.Context).yeok);
                shared.setString(((MainActivity) MainActivity.Context).Context, "hang", ((MainActivity) MainActivity.Context).hang);
                ((MainActivity) MainActivity.Context).yeok = yeok;
                ((MainActivity) MainActivity.Context).hang = hang;
                ((MainActivity) MainActivity.Context).textS.setText(((MainActivity) MainActivity.Context).yeok + "역 ");

            }
        });


    }

    public void onBackPressed() {
        super.onBackPressed();
        //((MainActivity) MainActivity.Context).textW.setText(((MainActivity) MainActivity.Context).compsi + ((MainActivity) MainActivity.Context).compgun);
        ((MainActivity) MainActivity.Context).textH.setText(((MainActivity) MainActivity.Context).compsi + " " + ((MainActivity) MainActivity.Context).compgun);
        shared.setString(((MainActivity) MainActivity.Context).Context, "compsi", ((MainActivity) MainActivity.Context).compsi);
        shared.setString(((MainActivity) MainActivity.Context).Context, "compgun", ((MainActivity) MainActivity.Context).compgun);
        shared.setString(((MainActivity) MainActivity.Context).Context, "yeok", ((MainActivity) MainActivity.Context).yeok);
        char[] picdata = ((MainActivity) MainActivity.Context).wp(((MainActivity) MainActivity.Context).data);
        System.out.println("설정에서나온데이텋");
        System.out.println(((MainActivity) MainActivity.Context).data);
        System.out.println("설정에서나온데이텋");
        if (picdata[0] == 's') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.sunny);
        } else if (picdata[0] == 'r') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.rain);
        } else if (picdata[0] == 'd') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.cloud);
        } else if (picdata[0] == 'n') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.snow);
        } else if (picdata[0] == 'c') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.littlecloud);
        } else ;

        if (picdata[1] == 's') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.sunny);
        } else if (picdata[1] == 'r') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.rain);
        } else if (picdata[1] == 'd') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.cloud);
        } else if (picdata[1] == 'n') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.snow);
        } else if (picdata[1] == 'c') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.littlecloud);
        } else ;

        if (picdata[2] == 's') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.sunny);
        } else if (picdata[2] == 'r') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.rain);
        } else if (picdata[2] == 'd') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.cloud);
        } else if (picdata[2] == 'n') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.snow);
        } else if (picdata[2] == 'c') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.littlecloud);
        } else ;


    }
}
