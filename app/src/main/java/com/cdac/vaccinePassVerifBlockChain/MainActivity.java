package com.cdac.vaccinePassVerifBlockChain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	static List<Block> lst = new ArrayList<Block>();
	public static int difficulty = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        bd();
    }

    private void initComponents(){
        findViewById(R.id.buttonTakePicture).setOnClickListener(this);
        findViewById(R.id.buttonScanBarcode).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonScanBarcode:
                startActivity(new Intent(this,ScannerBarcodeActivity.class));
                break;
            case R.id.buttonTakePicture:
                startActivity(new Intent(this,PictureBarcodeActivity.class));
                break;
        }
    }
     public void bd(){

		 String QrHash1 = StringUtil.applySha256("0;Amine Alaoui;CD220309;19/04/2021;19/06/2021;Astrazenca");
		 String QrHash2 = StringUtil.applySha256("0;Mohamed El hlafi;Z610552;19/04/2021;19/06/2021;sinopharme");

		 String QrHash3 = StringUtil.applySha256("1;Ahmed Mrabet;Z23907;15/02/2021;15/06/2021;Pfeizer");
		 String QrHash4 = StringUtil.applySha256("2;Ali benoun;A203907;09/05/2021;09/08/2021;Astrazeneca");
		 String QrHash5 = StringUtil.applySha256("2;Khalid Laabi;C23967;09/05/2021;09/08/2021;Pfeizer");
		 String QrHash6 = StringUtil.applySha256("2;Mohamed Hilal;Z620552;09/05/2021;09/08/2021;sinopharme");
		 String QrHash7 = StringUtil.applySha256("3;Adil Mzaiti;AA620552;10/05/2021;10/08/2021;sinopharme");
		 String QrHash8 = StringUtil.applySha256("3;Jamal Elhiane;Z610552;10/05/2021;10/08/2021;sinopharme");


		 Block genesisBlock = new Block(QrHash1+"@"+QrHash2,"0");
		 lst.add(genesisBlock);
		 lst.get(0).mineBlock(difficulty);

		 Block secondBlock = new Block(QrHash3,genesisBlock.hash);
		 lst.add(secondBlock);
		 lst.get(1).mineBlock(difficulty);

		 Block thirdBlock = new Block(QrHash4+"@"+QrHash5+"@"+QrHash6,secondBlock.hash);
		 lst.add(thirdBlock);
		 lst.get(2).mineBlock(difficulty);

		 Block fourthBlock = new Block(QrHash7+"@"+QrHash8,thirdBlock.hash);
		 lst.add(fourthBlock);
		 lst.get(3).mineBlock(difficulty);

		 String blockchainJson = StringUtil.getJson(lst);
		 System.out.println("notre chaine : " +blockchainJson);

	 }
}
