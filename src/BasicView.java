package com.seumxmobileagent;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Dialog;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.control.*;
import javafx.scene.image.*; 
import javafx.geometry.*;
import javafx.scene.layout.*;
import java.util.*; import java.io.*;import javafx.collections.*; //import com.gluonhq.charm.glisten.control.NavigationDrawer.*;
import com.gluonhq.charm.glisten.layout.layer.*; //import javafx.event.*;
import javafx.animation.*;
//import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration; import javafx.scene.web.*; import java.net.*;

//hardware imports
import com.gluonhq.charm.down.*; import com.gluonhq.charm.down.plugins.DialerService;

public class BasicView extends View {

    public BasicView() {
        
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        //main uper pane
        Label tt=new Label("SeumX Mobile Agent"); tt.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:aliceblue");
        List<String> nts=new ArrayList(); nts.add("airtel"); nts.add("mtn"); ObservableList<String> obs=FXCollections.observableArrayList(nts);
        ComboBox<String> nt=new ComboBox(); nt.setPrefWidth(89); nt.setItems(obs);
        nt.setStyle("-fx-font:normal 15px 'Cambria';-fx-background-color:lightblue"); 
        
        //lower Pane
        Label al=new Label("SeumX Plus (C) 2019. All Rights Reserved. ");
        al.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:aliceblue");
        HBox lw=new HBox(); lw.setPadding(new Insets(1)); lw.setAlignment(Pos.CENTER);
        lw.getChildren().addAll(al); setBottom(lw);
        
        //database ckeck
        Properties pr; String bna=""; String ana=""; String thm;
        try {
        File file=new File("data.bat"); 
        if(file.exists()) {
            FileInputStream in=new FileInputStream(file);
            ObjectInputStream obj=new ObjectInputStream(in);
            pr=(Properties) obj.readObject(); bna=pr.getProperty("bname"); ana=pr.getProperty("aname"); thm=pr.getProperty("theme");
            
            //bg
            if(thm.equals("default")) {
                appBar.setStyle("-fx-background-color:blueviolet"); lw.setStyle("-fx-background-color:blueviolet");
            }
            if(thm.equals("olivegreen")) {
                appBar.setStyle("-fx-background-color:darkolivegreen"); lw.setStyle("-fx-background-color:darkolivegreen");
            }
            if(thm.equals("purple")) {
                appBar.setStyle("-fx-background-color:purple"); lw.setStyle("-fx-background-color:purple");
            }
            if(thm.equals("pink")) {
                appBar.setStyle("-fx-background-color:deeppink"); lw.setStyle("-fx-background-color:deeppink");
            }
            if(thm.equals("aqua")) {
                appBar.setStyle("-fx-background-color:darkcyan"); lw.setStyle("-fx-background-color:darkcyan");
            }
            
        } else {
            appBar.setStyle("-fx-background-color:blueviolet"); lw.setStyle("-fx-background-color:blueviolet");
            bna="Businessname Here"; ana="Agent Name Here"; 
            //create the file
            Properties pr3=new Properties(); pr3.put("theme","default"); pr3.put("aname","Agent Name Here"); pr3.put("bname","Businessname Here");
            FileOutputStream out=new FileOutputStream("data.bat");
            ObjectOutputStream obj=new ObjectOutputStream(out);
            obj.writeObject(pr3);
        }
        
        } catch (IOException | ClassNotFoundException ex){
            System.out.println("File Not Found......");
        }
        
        
        
        //Airtel configs
        Label amy=new Label("airtel money"); amy.setStyle("-fx-font:bold 39px 'Cambria'; -fx-text-fill:red");
        Label ins=new Label("Simple, Secure, Instant"); ins.setStyle("-fx-font:normal 19px 'Cambria'; -fx-text-fill:darkred");
        Button dep=new Button("Deposit"); dep.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button wit=new Button("Withdraw"); wit.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button air=new Button("Airtime"); air.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button bds=new Button("Bundles"); bds.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button trs=new Button("Transfer"); trs.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button pay=new Button("Bill Payment"); pay.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button spr=new Button("Liquidate Float"); spr.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button ac=new Button("Account Management"); ac.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button wew=new Button("Wewole"); wew.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        
        dep.setPrefWidth(227); wit.setPrefWidth(227); air.setPrefWidth(227); trs.setPrefWidth(227); pay.setPrefWidth(227);
        spr.setPrefWidth(227); ac.setPrefWidth(227); wew.setPrefWidth(227); bds.setPrefWidth(227);
        
        //depoit process
        Label nod=new Label("Number : "); nod.setStyle("-fx-font:normal 15px 'Cambria'");
        Label amd=new Label("Amount : "); amd.setStyle("-fx-font:normal 15px 'Cambria'");
        TextField nodf=new TextField(); nodf.setStyle("-fx-font:normal 15px 'Cambria'");
        TextField amdf=new TextField(); amdf.setStyle("-fx-font:normal 15px 'Cambria'");
        Button subd=new Button("Submit"); subd.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        subd.setPrefWidth(177);
        
        //withdraw process
        Label now=new Label("Number : "); now.setStyle("-fx-font:normal 15px 'Cambria'");
        Label sre=new Label("Secret code: "); sre.setStyle("-fx-font:normal 15px 'Cambria'");
        TextField nowf=new TextField(); nowf.setStyle("-fx-font:normal 15px 'Cambria'");
        TextField sref=new TextField(); sref.setStyle("-fx-font:normal 15px 'Cambria'");
        Button subw=new Button("Submit"); subw.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        subw.setPrefWidth(177);
        
        //Airtime
        Label noa=new Label("Number : "); noa.setStyle("-fx-font:normal 15px 'Cambria'");
        Label ama=new Label("Amount : "); ama.setStyle("-fx-font:normal 15px 'Cambria'");
        TextField noaf=new TextField(); noaf.setStyle("-fx-font:normal 15px 'Cambria'");
        TextField amaf=new TextField(); amaf.setStyle("-fx-font:normal 15px 'Cambria'");
        Button suba=new Button("Submit"); suba.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        suba.setPrefWidth(177);
        
        //Transfer 
        Label nof=new Label("Number : "); nof.setStyle("-fx-font:normal 15px 'Cambria'");
        Label amf=new Label("Amount : "); amf.setStyle("-fx-font:normal 15px 'Cambria'");
        TextField noff=new TextField(); noff.setStyle("-fx-font:normal 15px 'Cambria'");
        TextField amff=new TextField(); amff.setStyle("-fx-font:normal 15px 'Cambria'");
        Button subf=new Button("Submit"); subf.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        subf.setPrefWidth(177);
        
        //Bundles
        Label bdl=new Label("Bundles"); bdl.setStyle("-fx-text-fill:red; -fx-font:bold 17px 'Cambria'");
        Button dtb=new Button("Data Bundles"); dtb.setStyle("-fx-background-color:darkred; -fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
        Button vbb=new Button("Voice Bundles"); vbb.setStyle("-fx-background-color:darkred; -fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
        Button ot=new Button("O.T.T Service tax"); ot.setStyle("-fx-background-color:darkred; -fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
        dtb.setPrefWidth(213); vbb.setPrefWidth(213); ot.setPrefWidth(213);
        
        //Bills
        Label bl=new Label("Bills"); bl.setStyle("-fx-text-fill:red; -fx-font:bold 17px 'Cambria'");
        Button ume=new Button("Umeme"); ume.setStyle("-fx-background-color:darkred; -fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
        Button tvs=new Button("Pay TV"); tvs.setStyle("-fx-background-color:darkred; -fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
        Button erc=new Button("E-recharge"); erc.setStyle("-fx-background-color:darkred; -fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
        Button othr=new Button("Others"); othr.setStyle("-fx-background-color:darkred; -fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
        ume.setPrefWidth(197); tvs.setPrefWidth(197); erc.setPrefWidth(197); othr.setPrefWidth(197);
        
        //umeme
        Label um=new Label("Umeme Bills"); um.setStyle("-fx-text-fill:red; -fx-font:bold 17px 'Cambria'");
        Button pbl=new Button("Pay Bill"); pbl.setStyle("-fx-background-color:darkred; -fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
        Button byk=new Button("Buy Yaka"); byk.setStyle("-fx-background-color:darkred; -fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
        pbl.setPrefWidth(197); byk.setPrefWidth(197);
        
        //pay Bill
        Label pbu=new Label("Pay Umeme Bill"); pbu.setStyle("-fx-text-fill:red; -fx-font:bold 17px 'Cambria'");
        TextField nop=new TextField(); nop.setStyle("-fx-font:normal 15px 'Cambria';"); nop.setPromptText("Enter Customer NO.");
        TextField acp=new TextField(); acp.setStyle("-fx-font:normal 15px 'Cambria';"); acp.setPromptText("Enter Account NO.");
        TextField amtp=new TextField(); amtp.setStyle("-fx-font:normal 15px 'Cambria';"); amtp.setPromptText("Enter Amount");
        Button subp=new Button("Submit"); subp.setStyle("-fx-font:normal 17px 'Cambria'; -fx-background-color:darkred;-fx-text-fill:azure");
        subp.setPrefWidth(197); nop.setPrefWidth(197); acp.setPrefWidth(197); amtp.setPrefWidth(197);
        
        //Buy Yaka
        Label ybu=new Label("Buy Yaka"); ybu.setStyle("-fx-text-fill:red; -fx-font:bold 17px 'Cambria'");
        TextField nob=new TextField(); nob.setStyle("-fx-font:normal 15px 'Cambria';"); nob.setPromptText("Enter Customer NO.");
        TextField acb=new TextField(); acb.setStyle("-fx-font:normal 15px 'Cambria';"); acb.setPromptText("Enter Account NO.");
        TextField amtb=new TextField(); amtb.setStyle("-fx-font:normal 15px 'Cambria';"); amtb.setPromptText("Enter Amount");
        Button subb=new Button("Submit"); subb.setStyle("-fx-font:normal 17px 'Cambria'; -fx-background-color:darkred;-fx-text-fill:azure");
        subb.setPrefWidth(197); nob.setPrefWidth(197); acb.setPrefWidth(197); amtb.setPrefWidth(197);
        
        //erecharge
        Label el=new Label("E-recharge"); el.setStyle("-fx-text-fill:red; -fx-font:bold 17px 'Cambria'");
        TextField noe=new TextField(); noe.setStyle("-fx-font:normal 15px 'Cambria';"); noe.setPromptText("Enter Customer NO.");
        TextField amte=new TextField(); amte.setStyle("-fx-font:normal 15px 'Cambria';"); amte.setPromptText("Enter Amount ");
        Button sube=new Button("Submit"); sube.setStyle("-fx-font:normal 17px 'Cambria'; -fx-background-color:darkred;-fx-text-fill:azure");
        noe.setPrefWidth(197); amte.setPrefWidth(197); sube.setPrefWidth(197);
        
        //others
        Label oth=new Label("Other Payments");oth.setStyle("-fx-text-fill:red; -fx-font:bold 17px 'Cambria'");
        TextField noo=new TextField(); noo.setStyle("-fx-font:normal 15px 'Cambria';"); noo.setPromptText("Enter Customer NO.");
        TextField bno=new TextField(); bno.setStyle("-fx-font:normal 15px 'Cambria';"); bno.setPromptText("Business Number");
        TextField amto=new TextField(); amto.setStyle("-fx-font:normal 15px 'Cambria';"); amto.setPromptText("Enter Amount");
        TextField ref=new TextField(); ref.setStyle("-fx-font:normal 15px 'Cambria';"); ref.setPromptText("Payment Reference");
        Button subo=new Button("Submit"); subo.setStyle("-fx-font:normal 17px 'Cambria'; -fx-background-color:darkred;-fx-text-fill:azure");
        noo.setPrefWidth(197); bno.setPrefWidth(197); amto.setPrefWidth(197); ref.setPrefWidth(197); subo.setPrefWidth(197);
        
        //Liquidate float
        Label lf=new Label("Liquidate Float"); lf.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:red");
        TextField amtl=new TextField(); amtl.setStyle("-fx-font:normal 15px 'Cambria'"); amtl.setPromptText("Enter amount ");
        TextField pinl=new TextField(); pinl.setStyle("-fx-font:normal 15px 'Cambria'"); pinl.setPromptText("Enter Pin");
        Button subl=new Button("Submit"); subl.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        amtl.setPrefWidth(197); pinl.setPrefWidth(197); subl.setPrefWidth(197);
        
        //Account management
        Label acm=new Label("Account Management"); acm.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:red");
        Button cba=new Button("Check Balance"); cba.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button aca=new Button("Accept Pull"); aca.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button coma=new Button("View Commision"); coma.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button pina=new Button("Change Pin"); pina.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button mina=new Button("Mini Statement"); mina.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        Button stata=new Button("Request Statement"); stata.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        acm.setPrefWidth(197); cba.setPrefWidth(197); aca.setPrefWidth(197); coma.setPrefWidth(197); pina.setPrefWidth(197);
        mina.setPrefWidth(197); stata.setPrefWidth(197);
        
        //Accept Pull
        Label acal=new Label("Accept Pull"); acal.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:red");
        TextField rid=new TextField(); rid.setStyle("-fx-font:normal 15px 'Cambria'"); rid.setPromptText("Enter Request ID");
        TextField msg=new TextField(); msg.setStyle("-fx-font:normal 15px 'Cambria'"); msg.setPromptText("Enter Your Message");
        Button subap=new Button("Submit"); subap.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        rid.setPrefWidth(197); msg.setPrefWidth(197); subap.setPrefWidth(197);
        
        //Pin reset
        Label pinal=new Label("Pin Reset"); pinal.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:red");
        TextField cur=new TextField(); cur.setStyle("-fx-font:normal 15px 'Cambria'"); cur.setPromptText("Enter Current Pin");
        TextField nw=new TextField(); nw.setStyle("-fx-font:normal 15px 'Cambria'"); nw.setPromptText("Enter new Pin");
        TextField rnw=new TextField(); rnw.setStyle("-fx-font:normal 15px 'Cambria'"); rnw.setPromptText("Re-enter new Pin");
        Button subpn=new Button("Submit"); subpn.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        cur.setPrefWidth(197); nw.setPrefWidth(197); rnw.setPrefWidth(197); subpn.setPrefWidth(197);
        
        //Request Statement 
        Label statal=new Label("Request Statement"); statal.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:red");
        TextField eml=new TextField(); eml.setStyle("-fx-font:normal 15px 'Cambria'"); eml.setPromptText("Enter Your Email");
        TextField fd=new TextField(); fd.setStyle("-fx-font:normal 15px 'Cambria'"); fd.setPromptText("Enter from Date (DDMMYYY)");
        TextField td=new TextField(); td.setStyle("-fx-font:normal 15px 'Cambria'"); td.setPromptText("Enter to Date (DDMMYYY)");
        Button substa=new Button("Submit"); substa.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        eml.setPrefWidth(197); fd.setPrefWidth(197); td.setPrefWidth(197); substa.setPrefWidth(197);
        
        //Entry Exception Dialog
        Dialog dlg=new Dialog(); Label ttt=new Label("Entry Error"); ttt.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:red");
        Label err=new Label("The entered values appear to be either incomplete Or too long.\nPlease check your values and submit again.");
        err.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:black");
        Button btn=new Button("OK"); btn.setStyle("-fx-font:bold 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkred");
        btn.setOnAction(ev->{
            dlg.hide();
        });
        
        dlg.setTitle(ttt); dlg.setContent(err); dlg.setGraphic(MaterialDesignIcon.ERROR.graphic()); dlg.getButtons().add(btn); 
        
        //mtn properties
        Label mtn=new Label("MTN Mobile Money"); mtn.setStyle("-fx-font:bold 27px 'Cambria'; -fx-text-fill:black");
        Label evr=new Label("       Every Where You Go"); evr.setStyle("-fx-font:normal 19px 'Cambria'; -fx-text-fill:black");
        GridPane mvb=new GridPane(); mvb.setPadding(new Insets(2,2,2,2)); mvb.setVgap(7); mvb.setHgap(3); mvb.setAlignment(Pos.CENTER);
        mvb.setStyle("-fx-background-color:yellow"); mvb.add(mtn,0,0); mvb.add(evr,0,1);
        
        Button msa=new Button("Sell Airtime"); msa.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        Button mft=new Button("Float Transfer"); mft.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        Button mw=new Button("Withdraw"); mw.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        Button mde=new Button("Deposit"); mde.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        Button mac=new Button("My Account"); mac.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        Button mas=new Button("Airtime Stock"); mas.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        Button mx=new Button("Xtra Float"); mx.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        Button mds=new Button("Bundles"); mds.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        msa.setPrefWidth(227); mft.setPrefWidth(227); mw.setPrefWidth(227); mde.setPrefWidth(227); mac.setPrefWidth(227); 
        mas.setPrefWidth(227); mx.setPrefWidth(227); mds.setPrefWidth(227);
        
        //sell airtime
        Label mat=new Label("Sell Airtime"); mat.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:darkgoldenrod");
        TextField mnoa=new TextField(); mnoa.setStyle("-fx-font:normal 15px 'Cambria';"); mnoa.setPromptText("Enter Number");
        TextField mama=new TextField(); mama.setStyle("-fx-font:normal 15px 'Cambria'"); mama.setPromptText("Enter Amount");
        Button subma=new Button("Submit"); subma.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:black; -fx-background-color:yellow");
        mnoa.setPrefWidth(197); mama.setPrefWidth(197); subma.setPrefWidth(157);
        
        //transfer float
        Label mf=new Label("Float Transfer"); mf.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:darkgoldenrod");
        TextField agd=new TextField(); agd.setStyle("-fx-font:normal 15px 'Cambria'"); agd.setPromptText("Enter Agent ID");
        TextField fam=new TextField(); fam.setStyle("-fx-font:normal 15px 'Cambria'"); fam.setPromptText("Enter Amount");
        TextField fre=new TextField(); fre.setStyle("-fx-font:normal 15px 'Cambria'"); fre.setPromptText("Reason");
        Button submf=new Button("Submit"); submf.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:black; -fx-background-color:yellow");
        agd.setPrefWidth(197); fam.setPrefWidth(197); fre.setPrefWidth(197); submf.setPrefWidth(157);
        
        //withdraw
        Label wtm=new Label("Withdraw Money"); wtm.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:darkgoldenrod");
        TextField wnom=new TextField(); wnom.setStyle("-fx-font:normal 15px 'Cambria'"); wnom.setPromptText("Enter Number");
        TextField wam=new TextField(); wam.setStyle("-fx-font:normal 15px 'Cambria'"); wam.setPromptText("Enter Amount");
        TextField wre=new TextField(); wre.setStyle("-fx-font:normal 15px 'Cambria'"); wre.setPromptText("Reference");
        Button submw=new Button("Submit"); submw.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:black; -fx-background-color:yellow");
        wnom.setPrefWidth(197); wam.setPrefWidth(197); wre.setPrefWidth(197); submw.setPrefWidth(157);
        
        //deposit
        Label mdep=new Label("Deposit Money"); mdep.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:darkgoldenrod");
        TextField dnom=new TextField(); dnom.setStyle("-fx-font:normal 15px 'Cambria'"); dnom.setPromptText("Enter Number");
        TextField dam=new TextField(); dam.setStyle("-fx-font:normal 15px 'Cambria'"); dam.setPromptText("Enter Amount");
        TextField dre=new TextField(); dre.setStyle("-fx-font:normal 15px 'Cambria'"); dre.setPromptText("Reference");
        Button submd=new Button("Submit"); submd.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:black; -fx-background-color:yellow");
        dnom.setPrefWidth(197); dam.setPrefWidth(197); dre.setPrefWidth(197); submd.setPrefWidth(157); 
        
        //my account
        Label macl=new Label("My Account"); macl.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:darkgoldenrod");
        Button mbal=new Button("Balance"); mbal.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        Button mini=new Button("Mini Statement");
        mini.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        Button mcp=new Button("Change Pin"); mcp.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        Button mcom=new Button("Commission"); mcom.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        mbal.setPrefWidth(177); mini.setPrefWidth(177); mcp.setPrefWidth(177); mcom.setPrefWidth(177); 
        
        //change pin
        Label cpp=new Label("Change Pin"); cpp.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:darkgoldenrod");
        TextField mcur=new TextField(); mcur.setStyle("-fx-font:normal 15px 'Cambria'"); mcur.setPromptText("Current Pin");
        TextField mnw=new TextField(); mnw.setStyle("-fx-font:normal 15px 'Cambria'"); mnw.setPromptText("New Pin");
        TextField mnc=new TextField(); mnc.setStyle("-fx-font:normal 15px 'Cambria'"); mnc.setPromptText("Confrim new Pin");
        Button submp=new Button("Submit"); submp.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:black; -fx-background-color:yellow");
        mcur.setPrefWidth(177); mnw.setPrefWidth(177); mnc.setPrefWidth(177); submp.setPrefWidth(157); 
        
        //airtime stock
        Label pas=new Label("Purchase Airtime Stock"); pas.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:darkgoldenrod");
        TextField asm=new TextField(); asm.setStyle("-fx-font:normal 15px 'Cambria'"); asm.setPromptText("Amount");
        Button subs=new Button("Submit"); subs.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:black; -fx-background-color:yellow");
        asm.setPrefWidth(177); subs.setPrefWidth(157); 
        
        //bundles
        Label mbl=new Label("Bundles"); mbl.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:darkgoldenrod");
        Button mvbs=new Button("Voice Bundles"); Button mibs=new Button("Internet Bundles");
        mvbs.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        mibs.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:darkgoldenrod");
        mvbs.setPrefWidth(177); mibs.setPrefWidth(177);
        
        //Main Panel
        Image im2=new Image(SeumxMobileAgent.class.getResource("/logo2.png").toExternalForm());
        ImageView vw2=new ImageView(im2); vw2.setFitWidth(197); vw2.setFitHeight(197);
        Label ea=new Label("Qiuck, Secure & Efficient"); ea.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:darkslateblue");
        RotateTransition rt=new RotateTransition(Duration.seconds(1)); rt.setCycleCount(7); rt.setAutoReverse(false); 
        rt.setNode(vw2); rt.setByAngle(1440); 
        FadeTransition fdt=new FadeTransition(Duration.seconds(21)); fdt.setFromValue(0); fdt.setToValue(1); fdt.setCycleCount(777);
        fdt.setAutoReverse(false); fdt.setNode(vw2);
        rt.setOnFinished(er->{
            fdt.play();
        });
        Button hm=new Button("Home"); hm.setStyle("-fx-background-color:darkred; -fx-font:bold 15px 'Cambria'; -fx-text-fill:azure");
        Button hn=new Button("Back To Home"); hn.setStyle("-fx-background-color:darkgoldenrod; -fx-font:bold 15px 'Cambria'; -fx-text-fill:azure");
        
        GridPane up=new GridPane(); up.setPadding(new Insets(2,2,2,2)); up.setVgap(9); up.setHgap(9); up.setAlignment(Pos.TOP_CENTER);
        up.add(amy,0,0); up.add(ins,0,1);
        GridPane it=new GridPane(); it.setPadding(new Insets(2,2,2,2)); it.setVgap(9); it.setHgap(9); it.setAlignment(Pos.TOP_CENTER);
        
        GridPane main=new GridPane(); main.setPadding(new Insets(0,0,0,0)); main.setVgap(9); main.setHgap(1); main.setAlignment(Pos.CENTER); 
        main.setStyle("-fx-background-color:white"); main.add(vw2,0,0); main.add(ea,0,2); ScrollPane spp=new ScrollPane(main);
        spp.setPadding(new Insets(0,0,0,0)); spp.autosize();
        
        GridPane pnnn=new GridPane(); pnnn.setPadding(new Insets(1,1,1,1)); pnnn.setAlignment(Pos.CENTER); 
        pnnn.add(spp,0,0);
        
        setCenter(pnnn); rt.play();
        
        //Primary Actions
        nt.setOnAction(ev->{
            if(nt.getValue().equals("airtel")){ rt.stop(); fdt.stop();
                nt.setStyle("-fx-font:normal 15px 'Cambria'; -fx-background-color:red; -fx-text-fill:azure");  
                main.getChildren().clear(); pnnn.setAlignment(Pos.TOP_CENTER);
                main.add(up,0,0); main.add(dep,0,2); main.add(wit,0,3); main.add(air,0,4); main.add(bds,0,5);
                main.add(trs,0,6); main.add(pay,0,7); main.add(spr,0,8); main.add(ac,0,9); main.add(wew,0,10);
            }
            if(nt.getValue().equals("mtn")){ rt.stop(); fdt.stop();
                nt.setStyle("-fx-font:normal 15px 'Cambria'; -fx-background-color:yellow"); 
                main.getChildren().clear(); pnnn.setAlignment(Pos.TOP_CENTER); 
                main.add(mvb,0,0); main.add(msa,0,2); main.add(mft,0,3); main.add(mw,0,4); main.add(mde,0,5);
                main.add(mds,0,6); main.add(mas,0,7); main.add(mx,0,8); main.add(mac,0,9);
            }
        });
        
        //Airtel Actions
        hm.setOnAction(ev->{
            nt.setStyle("-fx-font:normal 15px 'Cambria'; -fx-background-color:red; -fx-text-fill:azure");  
                main.getChildren().clear(); pnnn.setAlignment(Pos.TOP_CENTER);
                main.add(up,0,0); main.add(dep,0,2); main.add(wit,0,3); main.add(air,0,4);main.add(bds,0,5);
                main.add(trs,0,6); main.add(pay,0,7); main.add(spr,0,8); main.add(ac,0,9); main.add(wew,0,10);
        });
        
        dep.setOnAction(ev->{
            Label dd=new Label("Deposit Money"); dd.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:red");
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(dd,1,0); it.add(nod,0,3); it.add(nodf,1,3);
            it.add(amd,0,4); it.add(amdf,1,4); it.add(hm,0,7); it.add(subd,1,7); main.add(it,0,2);
        });
        
        wit.setOnAction(ev->{
            Label ww=new Label("Withdraw Money"); ww.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:red");
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(ww,1,0); it.add(now,0,3); it.add(nowf,1,3);
            it.add(sre,0,4); it.add(sref,1,4); it.add(hm,0,7); it.add(subw,1,7); main.add(it,0,2);
        });
        
        air.setOnAction(ev->{
            Label aa=new Label("Sell Airtime"); aa.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:red");
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(aa,1,0); it.add(noa,0,3); it.add(noaf,1,3);
            it.add(ama,0,4); it.add(amaf,1,4); it.add(hm,0,7); it.add(suba,1,7); main.add(it,0,2);
        });
        
        trs.setOnAction(ev->{
            Label tr=new Label("Transfer Float"); tr.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:red");
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(tr,1,0); it.add(nof,0,3); it.add(noff,1,3);
            it.add(amf,0,4); it.add(amff,1,4); it.add(hm,0,7); it.add(subf,1,7); main.add(it,0,2);
        });
        
        bds.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(bdl,0,0); it.add(dtb,0,3); it.add(vbb,0,4); 
            it.add(ot,0,5); it.add(hm,0,7); main.add(it,0,2);
        });
        
        pay.setOnAction(ev->{ 
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(bl,0,0); it.add(ume,0,3); it.add(tvs,0,4);
            it.add(erc,0,5); it.add(othr,0,6); it.add(hm,0,8); main.add(it,0,2);
        });
        
        ume.setOnAction(er->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(um,0,0); it.add(pbl,0,3); it.add(byk,0,4); 
            it.add(hm,0,5); main.add(it,0,2);
        });
        
        erc.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(el,0,0); it.add(noe,0,3); 
            it.add(amte,0,4); it.add(sube,0,5); it.add(hm,0,7); main.add(it,0,2);
        });
        
        pbl.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(pbu,0,0); it.add(nop,0,3); it.add(acp,0,4); 
            it.add(amtp,0,5); it.add(subp,0,7); it.add(hm,0,8); main.add(it,0,2);
        });
        
        byk.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(ybu,0,0); it.add(nob,0,3); it.add(acb,0,4);
            it.add(amtb,0,5); it.add(subb,0,7); it.add(hm,0,8); main.add(it,0,2);
        });
        
        othr.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(oth,0,0); it.add(noo,0,3); it.add(bno,0,4); 
            it.add(amto,0,5); it.add(ref,0,6); it.add(subo,0,8); it.add(hm,0,9); main.add(it,0,2);
        });
        
        spr.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(lf,0,0); it.add(amtl,0,3); it.add(pinl,0,4);
            it.add(subl,0,6); it.add(hm,0,7); main.add(it,0,2);
        });
        
        ac.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(acm,0,0); it.add(cba,0,3); it.add(aca,0,4); 
            it.add(coma,0,5); it.add(pina,0,6); it.add(mina,0,7); it.add(stata,0,8);it.add(hm,0,9); main.add(it,0,2);
        });
        
        aca.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(acal,0,0); it.add(rid,0,3); it.add(msg,0,4);
            it.add(subap,0,6); it.add(hm,0,7); main.add(it,0,2);
        });
        
        pina.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(pinal,0,0); it.add(cur,0,3); it.add(nw,0,4);
            it.add(rnw,0,5); it.add(subpn,0,7); it.add(hm,0,8); main.add(it,0,2);
        });
        
        stata.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(up,0,0); it.add(statal,0,0); it.add(eml,0,3); it.add(fd,0,4);
            it.add(td,0,5); it.add(substa,0,7); it.add(hm,0,8); main.add(it,0,2);
        });
        
        // Airtel Seconary Actions
        subd.setOnAction(er->{
            if(nodf.getText().length()>1 && amdf.getText().length()>2 && nodf.getText().length()==10 && amdf.getText().length()<8) {
                System.out.println("Depositing...."); 
                String cd="*185*1*1*"+nodf.getText()+"*"+amdf.getText()+"#";
                //depositing action
                Services.get(DialerService.class).ifPresent(service->{
                    service.call(cd);
                });
                nodf.setText(null); amdf.setText(null);
                
            } else {
                System.out.println("Invalid Input");
                //exception action
                dlg.showAndWait();
                
            }
        });
        
        subw.setOnAction(er->{
            if(nowf.getText().length()>1 && sref.getText().length()>1 && nowf.getText().length()==10 && sref.getText().length()==6) {
                String cd="*185*1*2*"+nowf.getText()+"*"+sref.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd);
                });
                nowf.setText(null); sref.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        suba.setOnAction(er->{
            if(noaf.getText().length()>1 && amaf.getText().length()>2 && noaf.getText().length()==10 && amaf.getText().length()<8) {
                String cd="*185*1*4*"+noaf.getText()+"*"+amaf.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd);
                });
                noaf.setText(null); amaf.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        subf.setOnAction(er->{
            if(noff.getText().length()>1 && amff.getText().length()>2 && noff.getText().length()==10 && amff.getText().length()<8){
                String cd="*185*5*1*"+noff.getText()+"*"+amff.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd);
                });
                noff.setText(null); amff.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        dtb.setOnAction(er->{
            Services.get(DialerService.class).ifPresent(serv->{
                serv.call("*185*1*5#");
            });
        });
        
        vbb.setOnAction(er->{
            Services.get(DialerService.class).ifPresent(serv->{
                serv.call("*185*1*6#");
            });
        });
        
        ot.setOnAction(er->{
            Services.get(DialerService.class).ifPresent(serv->{
                serv.call("*185*1*7#");
            });
        });
        
        subp.setOnAction(er->{
            if(amtp.getText().length()>2 && nop.getText().length()==10 && amtp.getText().length()<8 && acp.getText().length()>7){
                Services.get(DialerService.class).ifPresent(serv->{
                    String cd="*185*2*1*1*"+nop.getText()+"*"+acp.getText()+"*"+amtp.getText()+"#";
                    serv.call(cd);
                });
                amtp.setText(null); nop.setText(null); acp.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        subb.setOnAction(er->{
            if(amtb.getText().length()>2 && nob.getText().length()==10 && amtb.getText().length()<8 && acb.getText().length()>7){
                Services.get(DialerService.class).ifPresent(serv->{
                    String cd="*185*2*1*3*"+nob.getText()+"*"+acb.getText()+"*"+amtb.getText()+"#";
                    serv.call(cd);
                });
                amtb.setText(null); nob.setText(null); acb.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        sube.setOnAction(er->{
            if(amte.getText().length()>2 && noe.getText().length()==10 && amte.getText().length()<8){
                String cd="*85*2*5*"+noe.getText()+"*"+amte.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd);
                });
                amte.setText(null); noe.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        subo.setOnAction(er->{
            if(amto.getText().length()>2 && noo.getText().length()==10 && amto.getText().length()<8 && bno.getText().length()==10 && ref.getText()!=null){
                String cd="*185*2*6*"+noo.getText()+"*"+bno.getText()+"*"+amto.getText()+"*"+ref.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd);
                });
                amto.setText(null); noo.setText(null); bno.setText(null); ref.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        subl.setOnAction(er->{
            if(amtl.getText()!=null && pinl.getText()!=null) {
                String cd="*185*3*1*"+amtl.getText()+"*"+pinl.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
                amtl.setText(null); pinl.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        subap.setOnAction(er->{
            if(rid.getText()!=null && msg.getText()!=null){
                String cd="*185*5*3*"+rid.getText()+"*"+msg.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
                rid.setText(null); msg.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        subpn.setOnAction(er->{
            if(nw.getText().equals(rnw.getText()) && cur.getText()!=null){
                String cd="*185*5*5*"+cur.getText()+"*"+nw.getText()+"*"+rnw.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
                nw.setText(null); rnw.setText(null); cur.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        substa.setOnAction(er->{
            if(eml.getText()!=null && !fd.getText().equals("") && !td.getText().equals("")){
                String cd="*185*5*7*"+eml.getText()+"*"+fd.getText()+"*"+td.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
                eml.setText(null); fd.setText(null); td.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        tvs.setOnAction(ev->{
            String cd="*185*2*3#";
            Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
        });
        
        cba.setOnAction(ev->{
            String cd="*185*5*2#";
            Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
        });
        
        coma.setOnAction(ev->{
            String cd="*185*5*4*1#";
            Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
        });
        
        mina.setOnAction(ev->{
            String cd="*185*5*6#";
            Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
        });
        
        wew.setOnAction(ev->{
            String cd="*185*6#";
            Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
        });
        
        //Mtn Actions
        hn.setOnAction(ev->{
            main.getChildren().clear(); pnnn.setAlignment(Pos.TOP_CENTER); 
                main.add(mvb,0,0); main.add(msa,0,2); main.add(mft,0,3); main.add(mw,0,4); main.add(mde,0,5);
                main.add(mds,0,6); main.add(mas,0,7); main.add(mx,0,8); main.add(mac,0,9);
        });
        
        msa.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(mvb,0,0); it.add(mat,0,0); it.add(mnoa,0,3);
            it.add(mama,0,4); it.add(subma,0,6); it.add(hn,0,7); main.add(it,0,2);
        });
        
        mft.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(mvb,0,0); it.add(mf,0,0); it.add(agd,0,3);
            it.add(fam,0,4); it.add(fre,0,5); it.add(submf,0,7); it.add(hn,0,8); main.add(it,0,2);
        });
        
        mw.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(mvb,0,0); it.add(wtm,0,0); it.add(wnom,0,3);
            it.add(wam,0,4); it.add(wre,0,5); it.add(submw,0,7); it.add(hn,0,8); main.add(it,0,2);
        });
        
        mde.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(mvb,0,0); it.add(mdep,0,0); it.add(dnom,0,3); 
            it.add(dam,0,4); it.add(dre,0,5); it.add(submd,0,7); it.add(hn,0,8); main.add(it,0,2);
        });
        
        mac.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(mvb,0,0); it.add(macl,0,0); it.add(mbal,0,3);
            it.add(mini,0,4); it.add(mcp,0,5); it.add(mcom,0,6); it.add(hn,0,7); main.add(it,0,2);
        });
        
        mcp.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(mvb,0,0); it.add(cpp,0,0); it.add(mcur,0,3);
            it.add(mnw,0,4); it.add(mnc,0,5); it.add(submp,0,7); it.add(hn,0,8); main.add(it,0,2);
        });
        
        mas.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(mvb,0,0); it.add(pas,0,0); it.add(asm,0,3);
            it.add(subs,0,5); it.add(hn,0,7); main.add(it,0,2);
        });
        
        mds.setOnAction(ev->{
            main.getChildren().clear(); it.getChildren().clear(); main.add(mvb,0,0); it.add(mbl,0,0); it.add(mvbs,0,3);
            it.add(mibs,0,4); it.add(hn,0,5); main.add(it,0,2);
        });
        
        //Secondary mtn Actions
        subma.setOnAction(ev->{
            if(mnoa.getText().length()==10 && mama.getText().length()>2 && mama.getText().length()<8){
                String cd="*165*1"+mnoa.getText()+"*"+mama.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
                mnoa.setText(null); mama.setText(null); 
            } else {
                dlg.showAndWait();
            }
        });
        
        submf.setOnAction(ev->{
            if(agd.getText()!=null && fam.getText()!=null && fre.getText().length()>1){
                String cd="*165*2*"+agd.getText()+"*"+fam.getText()+"*"+fre.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd);
                });
                agd.setText(null); fam.setText(null); fre.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        submw.setOnAction(ev->{
            if(wnom.getText()!=null && wam.getText()!=null && wre.getText().length()>1) {
                String cd="*165*3*1*"+wnom.getText()+"*"+wam.getText()+"*"+wre.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
                wnom.setText(null); wam.setText(null); wre.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        submd.setOnAction(ev->{
            if(dnom.getText()!=null && dam.getText()!=null && dre.getText().length()>1){
                String cd="*165*4*"+dnom.getText()+"*"+dam.getText()+"*"+dre.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
                dnom.setText(null); dam.setText(null); dre.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        mbal.setOnAction(ev->{
            String cd="*165*8*1#";
            Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
        });
        
        mini.setOnAction(ev->{
            String cd="*165*8*2#";
            Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
        });
        
        mcp.setOnAction(ev->{
            if(mcur.getText()!=null && mnw.getText().equals(mnc.getText())) {
                String cd="*165*8*3*"+mcur.getText()+"*"+mnw.getText()+"*"+mnc.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
                mcur.setText(null); mnw.setText(null); mnc.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        mcom.setOnAction(ev->{
            String cd="*165*8*5#";
            Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
        });
        
        subs.setOnAction(ev->{
            if(asm.getText()!=null) {
                String cd="*165*6*"+asm.getText()+"#";
                Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
                asm.setText(null);
            } else {
                dlg.showAndWait();
            }
        });
        
        mvbs.setOnAction(ev->{
            String cd="*165*7*1#";
            Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
        });
        
        mibs.setOnAction(ev->{
            String cd="*165*7*2#";
            Services.get(DialerService.class).ifPresent(serv->{
                    serv.call(cd); 
                });
        });
        
        //Navigation bar
        
            //image logo
            Image im=new Image(SeumxMobileAgent.class.getResource("/logo.png").toExternalForm());
            ImageView vw=new ImageView(im); vw.setFitWidth(197); vw.setFitHeight(197);
            
            //Labels
            Label sm=new Label("SeumX+"); sm.setStyle("-fx-font:normal 23px 'Cambria'; -fx-text-fill:darkred"); 
            Label co=new Label(bna); co.setStyle("-fx-font:bold 18px 'Cambria'; -fx-text-fill:navy");
            Label an=new Label(ana); an.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:navy");
            Label th=new Label("Theme"); th.setStyle("-fx-font:normal 17px 'Cambria'; -fx-text-fill:green"); co.setPrefWidth(219);
            ComboBox<String> cb=new ComboBox(); cb.setStyle("-fx-font:normal 15px 'Cambria'; -fx-background-color:lightsteelblue");
            cb.setPrefWidth(97); cb.getItems().addAll("default","olivegreen","purple","pink","aqua");
            
            Button edt=new Button("Edit User Data");
            edt.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:black; -fx-background-color:lightsteelblue");
            /*Button str=new Button("Start"); 
            str.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:black; -fx-background-color:lightsteelblue");*/
            Hyperlink abt=new Hyperlink("About Us"); abt.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:black");
            
            //LayOut
            VBox vb=new VBox(); vb.setPadding(new Insets(9,9,9,9)); vb.setStyle("-fx-background-color:lightgrey");
            vb.getChildren().addAll(vw,sm,co,an);
            GridPane pn=new GridPane(); pn.setPadding(new Insets(0,0,0,0)); pn.setVgap(2); pn.setHgap(0); 
            pn.setStyle("-fx-background-color:white"); pn.add(vb,0,0); pn.add(edt,0,1); pn.add(abt,0,2); 
            pn.add(th,0,7); pn.add(cb,0,8);
            SidePopupView sp=new SidePopupView(pn);
            
            //Actions
            /*str.setOnAction(ev->{
                main.setAlignment(Pos.CENTER);
                main.getChildren().clear(); main.add(vw2,0,0); main.add(ea,0,2); setCenter(pnnn); rt.play(); 
                nt.setValue(null); nt.setStyle("-fx-background-color:lightsteelblue; -fx-font:normal 15px 'Cambria'");`
            });*/
            
            edt.setOnAction(ev->{
            Label rgs=new Label("SignIn"); rgs.setStyle("-fx-font:bold 17px 'Cambria'; -fx-text-fill:navy");
            Label bname=new Label("Businessname : "); bname.setStyle("-fx-font:normal 15px 'Cambria'");
            Label aname=new Label("Agent Name : "); aname.setStyle("-fx-font:normal 15px 'Cambria'");
            TextField bnam=new TextField(); bnam.setStyle("-fx-font:normal 15px 'Cambria'"); bnam.setPrefWidth(157);
            TextField anam=new TextField(); anam.setStyle("-fx-font:normal 15px 'Cambria'"); anam.setPrefWidth(157);
            Button sv=new Button("Save",MaterialDesignIcon.SAVE.graphic()); sv.setPrefWidth(129);
            sv.setStyle("-fx-background-color:navy; -fx-text-fill:azure; -fx-font:normal 15px 'Cambria'");
            
            GridPane svv=new GridPane(); svv.setPadding(new Insets(2,2,2,2)); svv.setVgap(7); svv.setHgap(7); svv.setAlignment(Pos.CENTER);
            svv.setStyle("-fx-background-color:white"); svv.add(bname,0,2); svv.add(bnam,1,2); svv.add(aname,0,3); 
            svv.add(anam,1,3); svv.add(sv,1,5);
            
            Dialog ddg=new Dialog(); ddg.setTitle(rgs); ddg.setContent(svv); 
            
             sv.setOnAction(evy->{
                 try {
                 if(bnam.getText()!=null && anam.getText()!=null) {
                     Properties pr4; 
                     FileInputStream in1=new FileInputStream("data.bat");
                     ObjectInputStream obj1=new ObjectInputStream(in1);
                     pr4=(Properties) obj1.readObject();
                     
                     pr4.put("bname",bnam.getText()); pr4.put("aname",anam.getText());
                     FileOutputStream out1=new FileOutputStream("data.bat");
                     ObjectOutputStream obju=new ObjectOutputStream(out1);
                     obju.writeObject(pr4);
                     
                     //setting
                     co.setText(bnam.getText()); an.setText(anam.getText());
                 }
                 ddg.hide();
                 } catch (IOException | ClassNotFoundException ex) {
                     System.out.println("Error reading file....");
                 }
             });
             
            sp.hide(); ddg.showAndWait();
            
            });
            
            abt.setOnAction(ev->{ sp.hide();
                WebView web=new WebView();
                WebEngine eng=web.getEngine();
                File f=new File(SeumxMobileAgent.class.getResource("/help.html").toExternalForm());
                try {
                URL ur=new URL(f.toString()); 
                eng.load(ur.toString());
                
                //Creating Dialog
                Button t=new Button("OK"); t.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure; -fx-background-color:navy");
                Dialog hy=new Dialog(); hy.setContent(web); hy.getButtons().addAll(t);
                
                t.setOnAction(er->{
                    hy.hide();
                });
                
                hy.showAndWait();
                
                } catch (MalformedURLException ec){
                    System.out.println("Error with URL.....");
                }
            });
            
            cb.setOnAction(ev->{
                if(cb.getValue().equals("default")) {
                    appBar.setStyle("-fx-background-color:blueviolet");
                    lw.setStyle("-fx-background-color:blueviolet");
                    
                    //read and write data file
                    try { Properties pr5;
                        FileInputStream in3=new FileInputStream("data.bat");
                        ObjectInputStream obj3=new ObjectInputStream(in3);
                        pr5=(Properties) obj3.readObject();
                        
                        pr5.put("theme", cb.getValue());
                        FileOutputStream out3=new FileOutputStream("data.bat");
                        ObjectOutputStream obju2=new ObjectOutputStream(out3);
                        obju2.writeObject(pr5);
                    } catch (IOException | ClassNotFoundException ex){
                        System.out.println("Error reading data file....");
                    }
                }
                if(cb.getValue().equals("olivegreen")) {
                    appBar.setStyle("-fx-background-color:darkolivegreen");
                    lw.setStyle("-fx-background-color:darkolivegreen");
                    
                    //read and write data file
                    try { Properties pr5;
                        FileInputStream in3=new FileInputStream("data.bat");
                        ObjectInputStream obj3=new ObjectInputStream(in3);
                        pr5=(Properties) obj3.readObject();
                        
                        pr5.put("theme", cb.getValue());
                        FileOutputStream out3=new FileOutputStream("data.bat");
                        ObjectOutputStream obju2=new ObjectOutputStream(out3);
                        obju2.writeObject(pr5);
                    } catch (IOException | ClassNotFoundException ex){
                        System.out.println("Error reading data file....");
                    }
                }
                if(cb.getValue().equals("purple")) {
                    appBar.setStyle("-fx-background-color:purple");
                    lw.setStyle("-fx-background-color:purple");
                    
                    //read and write data file
                    try { Properties pr5;
                        FileInputStream in3=new FileInputStream("data.bat");
                        ObjectInputStream obj3=new ObjectInputStream(in3);
                        pr5=(Properties) obj3.readObject();
                        
                        pr5.put("theme", cb.getValue());
                        FileOutputStream out3=new FileOutputStream("data.bat");
                        ObjectOutputStream obju2=new ObjectOutputStream(out3);
                        obju2.writeObject(pr5);
                    } catch (IOException | ClassNotFoundException ex){
                        System.out.println("Error reading data file....");
                    }
                }
                if(cb.getValue().equals("pink")) {
                    appBar.setStyle("-fx-background-color:deeppink");
                    lw.setStyle("-fx-background-color:deeppink");
                    
                    //read and write data file
                    try { Properties pr5;
                        FileInputStream in3=new FileInputStream("data.bat");
                        ObjectInputStream obj3=new ObjectInputStream(in3);
                        pr5=(Properties) obj3.readObject();
                        
                        pr5.put("theme", cb.getValue());
                        FileOutputStream out3=new FileOutputStream("data.bat");
                        ObjectOutputStream obju2=new ObjectOutputStream(out3);
                        obju2.writeObject(pr5);
                    } catch (IOException | ClassNotFoundException ex){
                        System.out.println("Error reading data file....");
                    }
                }
                if(cb.getValue().equals("aqua")) {
                    appBar.setStyle("-fx-background-color:darkcyan");
                    lw.setStyle("-fx-background-color:darkcyan");
                    
                    //read and write data file
                    try { Properties pr5;
                        FileInputStream in3=new FileInputStream("data.bat");
                        ObjectInputStream obj3=new ObjectInputStream(in3);
                        pr5=(Properties) obj3.readObject();
                        
                        pr5.put("theme", cb.getValue());
                        FileOutputStream out3=new FileOutputStream("data.bat");
                        ObjectOutputStream obju2=new ObjectOutputStream(out3);
                        obju2.writeObject(pr5);
                    } catch (IOException | ClassNotFoundException ex){
                        System.out.println("Error reading data file....");
                    }
                }
            });
            
            //handling appBar actions
            appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> {
                sp.show();
            }));
            appBar.setTitle(tt);
            appBar.getActionItems().add(nt);
        
    }
}
