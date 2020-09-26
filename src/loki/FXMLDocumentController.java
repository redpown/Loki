/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loki;

import java.io.IOException;
import loki.components.Components;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import javafx.event.EventHandler;
import java.awt.event.InputMethodEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author integra6
 */
public class FXMLDocumentController implements Initializable {
    
public Components FormatarTexto = new Components();
//---------------------------------------------------------------------------------------
public static String  tipo_chave = "";
public static int  tipo_nota =0;
public static int xml_pos = 0;  
public static int forn_erro = 0;
public static int qtchaves  = 1;    
public static double chaves_bar = 0.0;    
public static Connection connection = null;
public Statement stmt = null;
public File arquivos[];
public static File diretorio ;
public static File log_d ;
public static File fXmlFile;
public static int erro = 9999;
public static String Query                  = "" ;//select da base de dados
public static String DCNPJ                  = "" ;//select da base de dados
//----------------------------------contadores------------------------------------------
public static int count_prod_cod = 0;
public static int count_prod_descr = 0;
public static int count_prod_unid = 0;
public static int count_prod_ncm = 0; 
public static int count_prod_nbm = 0;
public static int count_prod_class_fiscal = 0;
public static int count_prod_isbn = 0;
public static int count_prod_aliq_icm = 0;
public static int count_prod_aliq_ipi = 0;
public static int count_prod_aliq_iss = 0; 
public static int count_prod_aliq_csll = 0;
public static int count_prod_aliq_cofins = 0;
public static int count_prod_aliq_pis = 0; 
public static int count_prod_aliq_icms_st = 0; 
public static int count_prod_trib_cfop_prod = 0; 
public static int count_prod_quantidade = 0;
public static int count_prod_valor_unitario = 0; 
public static int count_prod_valor_total = 0;
public static int count_prod_cod_temp = 0;

public static int count_dnfe_class_fiscal = 0;
public static int count_dnfe_cod_trib = 0; 
public static int count_dnfe_cfop = 0; 
public static int count_dnfe_cod_prod = 0;
public static int count_dnfe_cod_descr = 0;
public static int count_dnfe_unid_prod = 0;
public static int count_dnfe_quantidade = 0;
public static int count_dnfe_valor_unit = 0;
public static int count_dnfe_valor_total = 0;
public static int count_dnfe_valor_ipi = 0;
public static int count_dnfe_valor_icm = 0;
public static int count_dnfe_valor_desc = 0;
public static int count_dnfe_aliq_ipi = 0;
public static int count_dnfe_aliq_icm = 0;
public static int count_dnfe_aliq_iss = 0;
public static int count_dnfe_base_icm = 0;
public static int count_dnfe_base_ipi = 0;
public static int count_dnfe_base_iss = 0;
public static int count_dnfe_valor_iss = 0; 
public static int count_dnfe_base_irr = 0;
public static int count_dnfe_aliq_irr = 0;
public static int count_dnfe_valor_irr = 0;
public static int count_dnfe_trib_cfop_prod = 0;
public static int count_dnfe_forma_trib_nfe = 0;
public static int count_dnfe_base_subst_trib = 0;
public static int count_dnfe_valor_subst_trib = 0;
public static int count_dnfe_valor_trib_icms = 0;
public static int count_dnfe_valor_isento_icms = 0;
public static int count_dnfe_valor_outras_icms = 0;
public static int count_dnfe_valor_trib_ipi = 0;
public static int count_dnfe_valor_isento_ipi = 0;
public static int count_dnfe_valor_outras_ipi = 0;
public static int count_dnfe_base_pis = 0;
public static int count_dnfe_base_cofins = 0;
public static int count_dnfe_valor_pis = 0;
public static int count_dnfe_valor_cofins = 0;
public static int count_dnfe_codtrib_pis = 0;
public static int count_dnfe_codtrib_cofins = 0;
public static int count_dnfe_ctipi = 0;
public static int count_dnfe_id_produto = 0;
public static int count_dnfe_piscofins = 0;
public static int count_dnfe_valor_frete = 0;
public static int count_dnfe_outras_despesas = 0;
public static int count_dnfe_ctrc = 0;
public static int count_dnfe_prod_temp = 0;
public static int count_dnfe_cod_cli_filial = 0;
public static int count_dnfe_nf_situacao = 0;
public static int count_dnfe_peso = 0;
public static int count_dnfe_observacao = 0;
public static int count_dnfe_ct = 0;
public static int count_dnfe_situacao_piscofins = 0;
public static int CFS    =  0;
public static int C_PIS  = 0;
public static int C_IPI  = 0;
public static int C_ICMS = 0;
public static int P_PROD = 0;
	
//---------------------fim contadores----------------------------
public static String data_vigente = "";
public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

//------------------cap prod
public static int                temp                = 0;
public static String             prod_cod_empresa    = "";
public static ArrayList <String> prod_cod            = new ArrayList();
public static ArrayList <String> prod_descr          = new ArrayList();
public static String             prod_complem        = "";
public static String             prod_tipo           = "NFE_PROG";
public static ArrayList <String> prod_unid           = new ArrayList();
public static ArrayList <String> prod_ncm            = new ArrayList();
public static ArrayList <String> prod_nbm            = new ArrayList();
public static ArrayList <String> prod_class_fiscal   = new ArrayList();
public static ArrayList <String> prod_isbn           = new ArrayList();
public static ArrayList <String> prod_aliq_icm       = new ArrayList();
public static ArrayList <String> prod_aliq_ipi       = new ArrayList();
public static ArrayList <String> prod_aliq_iss       = new ArrayList();
public static ArrayList <String> prod_aliq_csll      = new ArrayList();
public static ArrayList <String> prod_aliq_cofins    = new ArrayList();
public static ArrayList <String> prod_aliq_pis       = new ArrayList();
public static ArrayList <String> prod_aliq_icms_st   = new ArrayList();
public static ArrayList <String> prod_trib_cfop_prod = new ArrayList();
public static ArrayList <String> prod_quantidade     = new ArrayList();
public static ArrayList <String> prod_valor_unitario = new ArrayList();
public static ArrayList <String> prod_valor_total    = new ArrayList();
public static ArrayList <String> prod_cod_temp       = new ArrayList();
//--------cad_fornec
public static String forn_cod_empresa    = "";//
public static String forn_cod_cli        = "";// 
public static String forn_pess_fj        = "";//
public static String forn_ecliente       = "";// 
public static String forn_efornecedor    = "";//
public static String forn_nome           = "";//
public static String forn_nomered        = "";// 
public static String forn_tipo_forn      = "";//
public static String forn_endereco       = "";//
public static String forn_numero         = "";//
public static String forn_municipio      = "";//
public static String forn_estado         = "";//
public static String forn_natureza       = "NFE_PROG"; 
public static String forn_bairro         = "";//
public static String forn_cep            = "";//
public static String forn_ddi            = "";//
public static String forn_ddd            = "";//
public static String forn_tel            = "";//
public static String forn_fax            = "";//
public static String forn_cgc            = "";//
public static String forn_inscrmunicial  = "";//
public static String forn_cpf            = "";//
public static String forn_ie             = "";//
public static String forn_rg             = "";//
public static String forn_email          = "";//
public static String forn_rec_cofins     = "";//
public static String forn_rec_csll       = "";//
public static String forn_rec_pis        = "";//
public static String forn_contribuinte   = "";//
public static String bpm_dt_criacao      = "NOW()";
public static String bpm_id_cliente      = "";//
public static String forn_tipo_cli       = "";//
public static String forn_cod_efiscal    = "";//
public static String forn_cod_municipio  = "";//
public static String forn_nm_munic_corr  = "";//
public static String forn_cgc_dig        = "";//
public static String forn_pais           = "";//
public static String forn_cod_pais       = "";//

//--------------------------------header
public static String hnfe_cod_empresa     = "";//
public static String hnfe_nr_nf           = "";//
public static String hnfe_relaciona_itens = "";// 
public static String hnfe_serie           = "";//
public static String hnfe_cod_forn        = "";//
public static String hnfe_dt_emissao      = "";//
public static String hnfe_nf_estado       = "";//
public static String hnfe_tipo_nf         = "NFE_PROG"; 
public static String hnfe_valor_merc      = "";//
public static String hnfe_valor_bruto     = "";//
public static String hnfe_valor_icms      = "";//
public static String hnfe_base_icms       = "";//
public static String hnfe_valor_ipi       = "";//
public static String hnfe_base_ipi        = "";//
public static String hnfe_valor_desc      = "";//
public static String hnfe_valor_frete     = "";//
public static String hnfe_valor_seguro    = "";//
public static String hnfe_outras_despesas = "";//
public static String hnfe_valor_icms_frete= "";//
public static String hnfe_rec_iss         = "";// 
public static String hnfe_nf_cancelada    = "";// 
public static String hnfe_dt_nf_canc      = "";// 
public static String hnfe_valor_iss       = "";// 
public static String hnfe_valor_bruto_ex  = "";// 
public static String hnfe_nf_especie      = "NF-E"; 
public static String hnfe_tem_1933        = "";//
public static String hnfe_base_subst_trib = "";// 
public static String hnfe_valor_subst_trib= "";// 
public static String hnfe_tem_1202        = "";// 
public static String hnfe_cfop            = "";// 
public static String hnfe_valor_pis       = "";// 
public static String hnfe_valor_cofins    = "";// 
public static String hnfe_valor_csll      = "";//  
public static String hnfe_processado      = "";//
public static String hnfe_dt_entrada      = "";// 
public static String hnfe_chave           = "";// 
public static String hnfe_valor_isento_ipi= "";// 
public static String hnfe_valor_outras_ipi= "";// 
public static String hnfe_base_iss        = "";// 
public static String hnfe_observacao      = "";// 
public static String hnfe_ctrc            = "";//
public static String hnfe_xml             = "";// 
public static String hnfe_cod_cli_filial  = "";// 
public static String hnfe_nf_situacao     = "";// 



//-----------------------details----------------------
public static String    dnfe_cod_empresa         = "";//
public static String    dnfe_nr_nf               = "";// 
public static String           dnfe_relaciona_itens     = "";// 
public static String    dnfe_serie               = "";// 
public static String    dnfe_cod_forn            = "";// 
public static String    dnfe_dt_emissao          = "";// 
public static String           dnfe_tipo                = "NFE_PROG"; 
public static ArrayList <String> dnfe_class_fiscal        = new ArrayList(); //
public static ArrayList <String> dnfe_cod_trib            = new ArrayList(); //
public static ArrayList <String> dnfe_cfop                = new ArrayList(); //
public static ArrayList          dnfe_nr_item             = new ArrayList(); //
public static ArrayList <String> dnfe_cod_prod            = new ArrayList();//
public static ArrayList <String> dnfe_cod_descr           = new ArrayList(); //
public static ArrayList <String> dnfe_unid_prod           = new ArrayList(); //
public static ArrayList <String> dnfe_quantidade          = new ArrayList(); //
public static ArrayList <String> dnfe_valor_unit          = new ArrayList(); //
public static ArrayList <String> dnfe_valor_total         = new ArrayList(); //
public static ArrayList <String> dnfe_valor_ipi           = new ArrayList(); //
public static ArrayList <String> dnfe_valor_icm           = new ArrayList(); //
public static ArrayList <String> dnfe_valor_desc          = new ArrayList();//
public static ArrayList <String> dnfe_aliq_ipi            = new ArrayList();//
public static ArrayList <String> dnfe_aliq_icm            = new ArrayList();//
public static ArrayList <String> dnfe_aliq_iss            = new ArrayList();//
public static ArrayList <String> dnfe_base_icm            = new ArrayList(); //
public static ArrayList <String> dnfe_base_ipi            = new ArrayList(); //
public static ArrayList <String> dnfe_base_iss            = new ArrayList(); //
public static ArrayList <String> dnfe_valor_iss           = new ArrayList(); //
public static ArrayList <String> dnfe_base_irr            = new ArrayList(); //
public static ArrayList <String> dnfe_aliq_irr            = new ArrayList(); //
public static ArrayList <String> dnfe_valor_irr           = new ArrayList(); //
public static ArrayList <String> dnfe_trib_cfop_prod      = new ArrayList(); //
public static ArrayList <String> dnfe_forma_trib_nfe      = new ArrayList(); //
public static String    dnfe_nf_cancelada        = "";// 
public static ArrayList <String> dnfe_base_subst_trib     = new ArrayList(); //
public static ArrayList <String> dnfe_valor_subst_trib    = new ArrayList(); //
public static ArrayList <String> dnfe_valor_trib_icms     = new ArrayList(); //
public static ArrayList <String> dnfe_valor_isento_icms   = new ArrayList(); 
public static ArrayList <String> dnfe_valor_outras_icms   = new ArrayList(); //
public static ArrayList <String> dnfe_valor_trib_ipi      = new ArrayList(); 
public static ArrayList <String> dnfe_valor_isento_ipi    = new ArrayList(); 
public static ArrayList <String> dnfe_valor_outras_ipi    = new ArrayList(); //
public static String    dnfe_nf_especie          = "NF-E";  
public static ArrayList <String> dnfe_base_pis            = new ArrayList();//
public static ArrayList <String> dnfe_base_cofins         = new ArrayList();//
public static ArrayList <String> dnfe_valor_pis           = new ArrayList();//
public static ArrayList <String> dnfe_valor_cofins        = new ArrayList();//
public static ArrayList <String> dnfe_codtrib_pis         = new ArrayList();//
public static ArrayList <String> dnfe_codtrib_cofins      = new ArrayList();//
public static String    dnfe_flag_control        = "";//
public static ArrayList <String> dnfe_ctipi               = new ArrayList();//
public static String    dnfe_processado          = "";//
public static String    dnfe_dt_entrada          = "";//  
public static ArrayList <String> dnfe_id_produto          = new ArrayList();
public static ArrayList <String> dnfe_piscofins           = new ArrayList();
public static ArrayList <String> dnfe_valor_frete         = new ArrayList();
public static ArrayList <String> dnfe_outras_despesas     = new ArrayList();
public static ArrayList <String> dnfe_ctrc                = new ArrayList();
public static ArrayList <String> dnfe_prod_temp           = new ArrayList();
public static ArrayList <String> dnfe_cod_cli_filial      = new ArrayList();
public static ArrayList <String> dnfe_nf_situacao         = new ArrayList();
public static ArrayList <String> dnfe_peso                = new ArrayList();
public static ArrayList <String> dnfe_observacao          = new ArrayList();
public static ArrayList <String> dnfe_ct                  = new ArrayList();
public static ArrayList <String> dnfe_situacao_piscofins  = new ArrayList();
public static ArrayList <String> dnfe_vlr_bas_fcp_retido_st    = new ArrayList();
public static ArrayList <String> dnfe_porcentual_fcp_retido_st = new ArrayList();
public static ArrayList <String> dnfe_vlr_fcp_retido_st        = new ArrayList();
public static ArrayList <String> dnfe_cod_cest                 = new ArrayList(); 


public static java.sql.Timestamp getCurrentTimeStamp() {

	java.util.Date today = new java.util.Date();
	return new java.sql.Timestamp(today.getTime());
 
}

    @FXML
    private ProgressBar progresso;

    //@FXML
   // public Label processos_id;
    
    @FXML
    private Button carregar_id;
    
    @FXML
    private Label label;
    
    @FXML
    private TextField diretorio_id;

    @FXML
    public TextField mes_id;
    
    @FXML
    public TextField ano_id;
    
    @FXML
    private Button btn_novo_p;
    
    @FXML
    private AnchorPane ancora;
    
    public void validar_data(){
       if(ano_id.getText().length()>4){
           ano_id.setText(ano_id.getText().substring(0,4)) ;
       }else{ 
           if(ano_id.getText().equals("")){
           ano_id.setText("0000"); 
           }
           else{
           ano_id.setText(ano_id.getText()); 
           }
       }
       if(mes_id.getText().length()>2){
            mes_id.setText(mes_id.getText().substring(0,2)) ;
       }else{
           if(mes_id.getText().equals("")){
             mes_id.setText("00"); 
           }else{
               mes_id.setText(mes_id.getText());
           }
          
        }
    }
     @FXML
     public void liberar_processo(){
         validar_data();
      if(Integer.parseInt(ano_id.getText())==0||Integer.parseInt(mes_id.getText())==0){
        carregar_id.setDisable(true);
      }else{
        carregar_id.setDisable(false);
        //Integer.parseInt(mes_id.getText())
      }
     }
   
    public void reload(){
    mes_id.setText("00");
    ano_id.setText("0000");
    progresso.setProgress(100);
    diretorio_id.setText("");
    }
     
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException{
           
         //progresso.setProgress(100);

            data_vigente = ano_id.getText()+"/"+mes_id.getText()+"/01";
/////////////////carregar arquivos////////////////////////////
    
    xml_pos = 0;  
            diretorio = new File(diretorio_id.getText());
            log_d = new File(diretorio+"\\Log.txt");
            FileOutputStream log_dir = new FileOutputStream(log_d);
          
            
    try (BufferedWriter lg = new BufferedWriter(new OutputStreamWriter(log_dir))) {
        lg.write("Processo executado : "+ getCurrentTimeStamp());
        lg.newLine();
    }
          diretorio = new File(diretorio_id.getText());    
            arquivos = diretorio.listFiles();
            qtchaves = 0;
      ////System.out.print(arquivos[0].toString().substring((arquivos[0].toString().length()- 3), arquivos[0].toString().length()));
            for(int arq = 0; arq <arquivos.length; arq++){
                ///variavel da barra de prgresso
           
count_prod_cod = 0;
count_prod_descr = 0;
count_prod_unid = 0;
count_prod_ncm = 0; 
count_prod_nbm = 0;
count_prod_class_fiscal = 0;
count_prod_isbn = 0;
count_prod_aliq_icm = 0;
count_prod_aliq_ipi = 0;
count_prod_aliq_iss = 0; 
count_prod_aliq_csll = 0;
count_prod_aliq_cofins = 0;
count_prod_aliq_pis = 0; 
count_prod_aliq_icms_st = 0; 
count_prod_trib_cfop_prod = 0; 
count_prod_quantidade = 0;
count_prod_valor_unitario = 0; 
count_prod_valor_total = 0;
count_prod_cod_temp = 0;

count_dnfe_class_fiscal = 0;
count_dnfe_cod_trib = 0; 
count_dnfe_cfop = 0; 
count_dnfe_cod_prod = 0;
count_dnfe_cod_descr = 0;
count_dnfe_unid_prod = 0;
count_dnfe_quantidade = 0;
count_dnfe_valor_unit = 0;
count_dnfe_valor_total = 0;
count_dnfe_valor_ipi = 0;
count_dnfe_valor_icm = 0;
count_dnfe_valor_desc = 0;
count_dnfe_aliq_ipi = 0;
count_dnfe_aliq_icm = 0;
count_dnfe_aliq_iss = 0;
count_dnfe_base_icm = 0;
count_dnfe_base_ipi = 0;
count_dnfe_base_iss = 0;
count_dnfe_valor_iss = 0; 
count_dnfe_base_irr = 0;
count_dnfe_aliq_irr = 0;
count_dnfe_valor_irr = 0;
count_dnfe_trib_cfop_prod = 0;
count_dnfe_forma_trib_nfe = 0;
count_dnfe_base_subst_trib = 0;
count_dnfe_valor_subst_trib = 0;
count_dnfe_valor_trib_icms = 0;
count_dnfe_valor_isento_icms = 0;
count_dnfe_valor_outras_icms = 0;
count_dnfe_valor_trib_ipi = 0;
count_dnfe_valor_isento_ipi = 0;
count_dnfe_valor_outras_ipi = 0;
count_dnfe_base_pis = 0;
count_dnfe_base_cofins = 0;
count_dnfe_valor_pis = 0;
count_dnfe_valor_cofins = 0;
count_dnfe_codtrib_pis = 0;
count_dnfe_codtrib_cofins = 0;
count_dnfe_ctipi = 0;
count_dnfe_id_produto = 0;
count_dnfe_piscofins = 0;
count_dnfe_valor_frete = 0;
count_dnfe_outras_despesas = 0;
count_dnfe_ctrc = 0;
count_dnfe_prod_temp = 0;
count_dnfe_cod_cli_filial = 0;
count_dnfe_nf_situacao = 0;
count_dnfe_peso = 0;
count_dnfe_observacao = 0;
count_dnfe_ct = 0;
count_dnfe_situacao_piscofins = 0;
forn_erro = 0;
//temp                = 0;

prod_cod_empresa    = "";
prod_complem        = "";


//---------fornecedor
forn_cod_empresa    = "";//
forn_cod_cli        = "";// 
forn_pess_fj        = "";//
forn_ecliente       = "";// 
forn_efornecedor    = "";//
forn_nome           = "";//
forn_nomered        = "";// 
forn_tipo_forn      = "";//
forn_endereco       = "";//
forn_numero         = "";//
forn_municipio      = "";//
forn_estado         = "";//
forn_bairro         = "";//
forn_cep            = "";//
forn_ddi            = "";//
forn_ddd            = "";//
forn_tel            = "";//
forn_fax            = "";//
forn_cgc            = "";//
forn_inscrmunicial  = "";//
forn_cpf            = "";//
forn_ie             = "";//
forn_rg             = "";//
forn_email          = "";//
forn_rec_cofins     = "";//
forn_rec_csll       = "";//
forn_rec_pis        = "";//
forn_contribuinte   = "";//
bpm_id_cliente      = "";//
forn_tipo_cli       = "";//
forn_cod_efiscal    = "";//
forn_cod_municipio  = "";//
forn_nm_munic_corr  = "";//
forn_cgc_dig        = "";//
forn_pais           = "";//
forn_cod_pais       = "";//

//-------------header
hnfe_cod_empresa     = "";//
hnfe_nr_nf           = "";//
hnfe_relaciona_itens = "";// 
hnfe_serie           = "";//
hnfe_cod_forn        = "";//
hnfe_dt_emissao      = "";//
hnfe_nf_estado       = "";//
hnfe_valor_merc      = "";//
hnfe_valor_bruto     = "";//
hnfe_valor_icms      = "";//
hnfe_base_icms       = "";//
hnfe_valor_ipi       = "";//
hnfe_base_ipi        = "";//
hnfe_valor_desc      = "";//
hnfe_valor_frete     = "";//
hnfe_valor_seguro    = "";//
hnfe_outras_despesas = "";//
hnfe_valor_icms_frete= "";//
hnfe_rec_iss         = "";// 
hnfe_nf_cancelada    = "";// 
hnfe_dt_nf_canc      = "";// 
hnfe_valor_iss       = "";// 
hnfe_valor_bruto_ex  = "";// 
hnfe_tem_1933        = "";//
hnfe_base_subst_trib = "";// 
hnfe_valor_subst_trib= "";// 
hnfe_tem_1202        = "";// 
hnfe_cfop            = "";// 
hnfe_valor_pis       = "";// 
hnfe_valor_cofins    = "";// 
hnfe_valor_csll      = "";//  
hnfe_processado      = "";//
hnfe_dt_entrada      = "";// 
hnfe_chave           = "";// 
hnfe_valor_isento_ipi= "";// 
hnfe_valor_outras_ipi= "";// 
hnfe_base_iss        = "";// 
hnfe_observacao      = "";// 
hnfe_ctrc            = "";//
hnfe_xml             = "";// 
hnfe_cod_cli_filial  = "";// 
hnfe_nf_situacao     = "";// 



//----details--------------------
dnfe_cod_empresa         = "";//
dnfe_nr_nf               = "";// 
dnfe_relaciona_itens     = "";// 
dnfe_serie               = "";// 
dnfe_cod_forn            = "";// 
dnfe_dt_emissao          = "";// 
dnfe_nf_cancelada        = "";// 
dnfe_flag_control        = "";//
dnfe_processado          = "";//
dnfe_dt_entrada          = "";// 

            
                
         if(arquivos[arq].toString().substring((arquivos[arq].toString().length()- 3), arquivos[arq].toString().length()).equals("xml")){        
            // ////System.out.println("Não é XML");    
             forn_cod_empresa = prod_cod_empresa = hnfe_cod_empresa = dnfe_cod_empresa = "";
             bpm_id_cliente = "";
             erro = 5;             
                ///*contar quantas chaves fortasm integradas
                
                
             
           // }
///////////////////////////fim///////////////////////////////////            
            
 try {
//aqui
	fXmlFile = new File(arquivos[arq].toString());
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();//SERVE PARA LIMPAR ELEMENTOS E TEXTOS VAZIOS
        
        
        //System.out.println("Root element :" + doc.getElementsByTagName("infProt"));
        
        /*
        Node nChave     = doc.getElementsByTagName(doc.getDocumentElement().getNodeName()).item(0).getChildNodes().item(0).getChildNodes().item(0);
        Element eChave  = (Element) nChave;
        tipo_chave = eChave.getAttribute("Id").substring(0,3);
        if(tipo_chave.equalsIgnoreCase("NFe")){
            tipo_nota = 0;
        }else{
            tipo_nota = 1;
        }
        */
        
        
       // Node nChave     = doc.getElementsByTagName(doc.getDocumentElement().getNodeName()).item(0).getChildNodes().item(0).getChildNodes().item(0);
       
        NodeList mod_ide_List = doc.getElementsByTagName("ide").item(0).getChildNodes();
	
        for (int temp = 0; temp < mod_ide_List.getLength(); temp++) {
		
            Node ide = mod_ide_List.item(temp);
		
            ////System.out.println("\nCurrent Element :" + ide.getNodeName());
		
            if (ide.getNodeType() == Node.ELEMENT_NODE) {
			
                Element eElement = (Element) ide;
                
                if(ide.getNodeName().equals("mod")){
                                
						tipo_chave = ide.getTextContent();
						
						if(tipo_chave.equalsIgnoreCase("55")){
									tipo_nota = 0;
									
									
										//-----------------------------NODE DE CHAVE ----------------------------------------------        
										NodeList infProtList = doc.getElementsByTagName("infProt").item(0).getChildNodes();

									// ////System.out.println("chave----------------------------");

									for (int y = 0; y < infProtList.getLength(); y++) {

										Node infProt = infProtList.item(y);

										// ////System.out.println("\nCurrent Element :" + nNode.getNodeName());

										if (infProt.getNodeType() == Node.ELEMENT_NODE) {

											Element mod2 = (Element) infProt;
													
													if(infProt.getNodeName().equals("chNFe")){
														if(infProt.getTextContent().length()>50){
															//System.out.println("chave: " + infProt.getTextContent());
															tipo_chave = infProt.getTextContent().substring(0,50);
														}else{
															//System.out.println("chave: " + infProt.getTextContent());
															tipo_chave = infProt.getTextContent();
														}
														
													   
													}
													
													
											 }
												
									}
									
									
									
							}else{
									tipo_nota = 1;
									
									//-----------------------------NODE DE CHAVE ----------------------------------------------        
										NodeList infProtList = doc.getElementsByTagName("infProt").item(0).getChildNodes();

									// ////System.out.println("chave----------------------------");

									for (int x = 0; x < infProtList.getLength(); x++) {

										Node infProt = infProtList.item(x);

										// ////System.out.println("\nCurrent Element :" + nNode.getNodeName());

										if (infProt.getNodeType() == Node.ELEMENT_NODE) {

											Element mod1 = (Element) infProt;
													
													if(infProt.getNodeName().equals("chCTe")){
														if(infProt.getTextContent().length()>50){
															//System.out.println("chave: " + infProt.getTextContent());
															tipo_chave = infProt.getTextContent().substring(0,50);
														}else{
															//System.out.println("chave: " + infProt.getTextContent());
															tipo_chave = infProt.getTextContent();
														}
														
													   
													}
													
													
											 }
												
									}
									
									
							}
        
                
                    
               
                }     
            }
		}
        
        
        xml_pos++;
       
        if(doc.getDocumentElement().getNodeName().toString().equals("nfeProc")){
         CFS    = 0;
         C_PIS  = 0;
         C_IPI  = 0;
         C_ICMS = 0;
         P_PROD = 0;
	////System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//-----------------------------IDENTIFICACAO----------------------------------------------
	NodeList ideList = doc.getElementsByTagName("ide").item(0).getChildNodes();
	
        for (int temp = 0; temp < ideList.getLength(); temp++) {
		
            Node ide = ideList.item(temp);
		
            ////System.out.println("\nCurrent Element :" + ide.getNodeName());
		
            if (ide.getNodeType() == Node.ELEMENT_NODE) {
			
                Element eElement = (Element) ide;
                
                if(ide.getNodeName().equals("nNF")){
                     if(ide.getTextContent().length()>20){
                        ////System.out.println("numeroNF : " + ide.getTextContent().substring(0,20));
                        hnfe_nr_nf      = dnfe_nr_nf      = ide.getTextContent().substring(0,20);
                     }else{
                        ////System.out.println("numeroNF : " + ide.getTextContent());
                        hnfe_nr_nf      = dnfe_nr_nf      = ide.getTextContent();
                     }  
                  
                
                }else if(ide.getNodeName().equals("serie")){
                    if(ide.getTextContent().length()>10){
                        ////System.out.println("serie : " + ide.getTextContent().substring(0,20));
                        dnfe_serie      = hnfe_serie      = ide.getTextContent().substring(0,20);
                    }else{
                        ////System.out.println("serie : " + ide.getTextContent());
                        dnfe_serie      = hnfe_serie      = ide.getTextContent();
                    }    
                    
               
                }else if(ide.getNodeName().equals("dhEmi")){
                       
                    ////System.out.println("data de emissao : " + ide.getTextContent());
                       
                    dnfe_dt_emissao = hnfe_dt_emissao = hnfe_dt_entrada = dnfe_dt_entrada = ide.getTextContent().substring(0, 4)+"/"+ide.getTextContent().substring(5,7)+"/"+ide.getTextContent().substring(8, 10);
                
                }else if(ide.getNodeName().equals("dhSaiEnt")){
                       
                    ////System.out.println("data de entrada : " + ide.getTextContent());
                        
                   //hnfe_dt_entrada = dnfe_dt_entrada = ide.getTextContent().substring(0, 4)+"/"+ide.getTextContent().substring(5,7)+"/"+ide.getTextContent().substring(8, 10);
                }else if(ide.getNodeName().equals("tpNF")){
                    if(ide.getTextContent().equalsIgnoreCase("0")){
                        ////System.out.println("serie : " + ide.getTextContent().substring(0,20));
                        ////System.out.println("Não é XML");
                        if((erro != 10) && (erro != 1) && (erro != 6) && (erro != 3)){
                                    
                                           erro = 7;
                                      }
                        
                    }  
                    
               
                }     
            }
	}
    if(formatter.parse(hnfe_dt_entrada).compareTo(formatter.parse(data_vigente))<0) {
     hnfe_dt_entrada = dnfe_dt_entrada = data_vigente;
    }
         //Date teste = formatter.parse(dateInString);
        //if( ){}else{}
       // //System.out.println("data"+dnfe_dt_entrada);
        //-----------------------------EMITENTE----------------------------------------------
        
        NodeList emitList = doc.getElementsByTagName("emit").item(0).getChildNodes();

	// ////System.out.println("fornecedor----------------------------");

	for (int temp = 0; temp < emitList.getLength(); temp++) {

		
            Node emit = emitList.item(temp);

		
            ////System.out.println("\nCurrent Element :" + emit.getNodeName());

		
            if (emit.getNodeType() == Node.ELEMENT_NODE) {
			
                Element eElement = (Element) emit;

                if(emit.getNodeName().equals("CNPJ")){
                    if(emit.getTextContent().length()>50){
                        ////System.out.println("CNPJ do fornecedor : " + emit.getNodeName().substring(0,50));
                        hnfe_cod_forn = dnfe_cod_forn = forn_cod_cli = forn_cgc  = emit.getTextContent().substring(0,50);
                    }else{
                        ////System.out.println("CNPJ do fornecedor : " + emit.getNodeName());
                        hnfe_cod_forn = dnfe_cod_forn = forn_cod_cli = forn_cgc  = emit.getTextContent();
                    }
                    

                }
                
                if(emit.getNodeName().equals("CPF")){
                    if(emit.getTextContent().length()>50){
                        ////System.out.println("CNPJ do fornecedor : " + emit.getNodeName().substring(0,50));
                        hnfe_cod_forn = dnfe_cod_forn = forn_cod_cli = forn_cgc  = emit.getTextContent().substring(0,50);
                    }else{
                        ////System.out.println("CNPJ do fornecedor : " + emit.getNodeName());
                        hnfe_cod_forn = dnfe_cod_forn = forn_cod_cli = forn_cgc  = emit.getTextContent();
                    }
                    

                }

                else if(emit.getNodeName().equals("xNome")){
                    if(emit.getTextContent().length()>150){
                        ////System.out.println("xNome : " + emit.getNodeName().substring(0,150));
                        forn_nome = FormatarTexto.formater(emit.getTextContent().substring(0,150));
                    }else{
                        ////System.out.println("xNome : " + emit.getNodeName());
                        forn_nome = FormatarTexto.formater(emit.getTextContent());
                    }

                }

                else if(emit.getNodeName().equals("xFant")){
                    if(emit.getTextContent().length()>100){
                        ////System.out.println("Nome Fantasia: " + emit.getNodeName().substring(0,100));
                        forn_nomered = FormatarTexto.formater(emit.getTextContent().substring(0,100));
                                            }else{
                        ////System.out.println("Nome Fantasia: " + emit.getNodeName());
                        forn_nomered = FormatarTexto.formater(emit.getTextContent());
                    }
                    

                }

                else if(emit.getNodeName().equals("IE")){                   
                    if(emit.getTextContent().length()>20){
                        ////System.out.println("Inscricao municipal : " + emit.getNodeName().substring(0,20));
                        forn_ie =  emit.getTextContent().substring(0,20);
                    }else{
                        ////System.out.println("Inscricao municipal : " + emit.getNodeName());
                        forn_ie =  emit.getTextContent();
                    }

                }   
                
            }
           
        }
 //-----------------------------EMITENTE CADASTRO----------------------------------------------
        
        
 NodeList emiCadtList = doc.getElementsByTagName("enderEmit").item(0).getChildNodes();
        //doc.getElementsByTagName(doc.getElementsByTagName("emit").item(0).getChildNodes()).item(0).getChildNodes();
                //doc.getElementsByTagName(doc.getElementsByTagName("emit").item(0).getChildNodes().item(0).getNodeName()).item(0).getChildNodes();

	
                ////System.out.println(" Cad_fornecedor----------------------------");

	
                for (int temp = 0; temp < emiCadtList.getLength(); temp++) {

                    Node enderEmit = emiCadtList.item(temp);

                    ////System.out.println("\nCad_fornecedor Current Element :" + enderEmit.getNodeName());

		
                    if (enderEmit.getNodeType() == Node.ELEMENT_NODE) {
			
                        Element eElement = (Element) enderEmit;

                        if(enderEmit.getNodeName().equals("xLgr")){
                            if(enderEmit.getTextContent().length()>500){
                                ////System.out.println("endereco : " + enderEmit.getTextContent().substring(0,500));
                                forn_endereco = FormatarTexto.formater(enderEmit.getTextContent().substring(0,500));
                                }else{
                                ////System.out.println("endereco : " + enderEmit.getTextContent());
                                forn_endereco = FormatarTexto.formater(enderEmit.getTextContent());
                            }

                        }

                        else if(enderEmit.getNodeName().equals("nro")){                    
                            if(enderEmit.getTextContent().length()>50){
                                ////System.out.println("Numero : " + enderEmit.getTextContent().substring(0,50));
                                forn_numero = FormatarTexto.formater(enderEmit.getTextContent().substring(0,50));
                                }else{
                                ////System.out.println("Numero : " + enderEmit.getTextContent());
                                forn_numero = FormatarTexto.formater(enderEmit.getTextContent());
                            }

                        }

                        else if(enderEmit.getNodeName().equals("xBairro")){                    
                             if(enderEmit.getTextContent().length()>100){
                                ////System.out.println("bairro : " + enderEmit.getTextContent().substring(0,100));
                                forn_bairro = FormatarTexto.formater(enderEmit.getTextContent().substring(0,100));
                             }else{
                                ////System.out.println("bairro : " + enderEmit.getTextContent());
                                forn_bairro = FormatarTexto.formater(enderEmit.getTextContent());
                             }
                            

                        }

                        else if(enderEmit.getNodeName().equals("cMun")){                    
                             if(enderEmit.getTextContent().length()>7){
                               ////System.out.println("codigo Minicipal : " + enderEmit.getTextContent().substring(0,7));
                                forn_cod_municipio  = enderEmit.getTextContent().substring(0,7);
                             }else{
                               // //System.out.println("codigo Minicipal : " + enderEmit.getTextContent());
                                forn_cod_municipio  = enderEmit.getTextContent();
                             }
                            

                        }

                        else if(enderEmit.getNodeName().equals("xMun")){                    
                             if(enderEmit.getTextContent().length()>100){
                                ////System.out.println("Municipio : " + enderEmit.getTextContent().substring(0,100));
                                forn_nm_munic_corr = FormatarTexto.formater(enderEmit.getTextContent().substring(0,100));
                             }else{
                                ////System.out.println("Municipio : " + enderEmit.getTextContent());
                                forn_nm_munic_corr = FormatarTexto.formater(enderEmit.getTextContent());
                             }
                        }
                            
                        else if(enderEmit.getNodeName().equals("UF")){                    
                             if(enderEmit.getTextContent().length()>20){
                                ////System.out.println("Estado : " + enderEmit.getTextContent().substring(0,20));
                                hnfe_nf_estado = forn_estado = FormatarTexto.formater(enderEmit.getTextContent().substring(0,20));
                                }else{
                                ////System.out.println("Estado : " + enderEmit.getTextContent());
                                hnfe_nf_estado = forn_estado = FormatarTexto.formater(enderEmit.getTextContent());
                             }
                         

                        }

                        else if(enderEmit.getNodeName().equals("CEP")){                    
                             if(enderEmit.getTextContent().length()>20){
                                ////System.out.println("Cep : " + enderEmit.getTextContent().substring(0,20));
                                forn_cep            = enderEmit.getTextContent().substring(0,20);
                                
                             }else{
                                ////System.out.println("Cep : " + enderEmit.getTextContent());
                                forn_cep            = enderEmit.getTextContent();
                             }
                          forn_cep = forn_cep.substring(0,5)+"-"+forn_cep.substring(5,forn_cep.length());

                        }

                        else if(enderEmit.getNodeName().equals("cPais")){                    
                             if(enderEmit.getTextContent().length()>20){
                                ////System.out.println("Codigo pais : " + enderEmit.getTextContent().substring(0,20));
                                forn_cod_pais       = enderEmit.getTextContent();
                             }else{
                                ////System.out.println("Codigo pais : " + enderEmit.getTextContent());
                                forn_cod_pais       = enderEmit.getTextContent();
                             }
                            

                        }

                        else if(enderEmit.getNodeName().equals("xPais")){                    
                             if(enderEmit.getTextContent().length()>50){
                                    ////System.out.println("Pais : " + enderEmit.getTextContent().substring(0,50));
                                    forn_pais = FormatarTexto.formater(enderEmit.getTextContent().substring(0,50));
                             }else{
                                    ////System.out.println("Pais : " + enderEmit.getTextContent());
                                    forn_pais = FormatarTexto.formater(enderEmit.getTextContent());
                             }
                           

                        }

                        else if(enderEmit.getNodeName().equals("fone")){                   
                             if(enderEmit.getTextContent().length()>40){
                                ////System.out.println("Fone : " + enderEmit.getTextContent().substring(0,40));
                                forn_tel            = enderEmit.getTextContent().substring(0,40);
                                
                             }else{
                                ////System.out.println("Fone : " + enderEmit.getTextContent());
                                forn_tel            = enderEmit.getTextContent();
                                
                             }
                             
                            if(forn_tel.substring(0,4).equals("0800")){
                              forn_tel =forn_tel.substring(0,4)+"-"+forn_tel.substring(4,7)+"-"+forn_tel.substring(7,forn_tel.length());
                            }else if(forn_tel.substring(0,1).equals("0")){
                              forn_tel ="("+forn_tel.substring(0,3)+")"+forn_tel.substring(3,7)+"-"+forn_tel.substring(7,forn_tel.length());
                            }else if(forn_tel.substring(0,2).equals("55")){
                              forn_tel ="("+forn_tel.substring(0,2)+"-"+"-"+forn_tel.substring(2,4)+")"+forn_tel.substring(4,8)+"-"+forn_tel.substring(8,forn_tel.length());
                            }else if(forn_tel.length()==11){
                              forn_tel ="("+forn_tel.substring(0,2)+")"+forn_tel.substring(2,7)+"-"+forn_tel.substring(7,forn_tel.length());
                            }else if(forn_tel.length()==10){
                              forn_tel ="("+forn_tel.substring(0,2)+")"+forn_tel.substring(2,6)+"-"+forn_tel.substring(6,forn_tel.length());
                            }else{
                              forn_tel =forn_tel.substring(0,4)+"-"+forn_tel.substring(4,forn_tel.length());
                            }

                        }
                    
                    }
                      forn_municipio =   forn_cod_municipio + " - "+ forn_nm_munic_corr;
                }        
        //2111300 - SAO LUIS
    //-----------------------------DESTINATARIO NOSSO CLINETE ----------------------------------------------    
        
    NodeList destList = doc.getElementsByTagName("dest").item(0).getChildNodes();

	
    ////System.out.println("Nosso cliente----------------------------");

	
    for (int temp = 0; temp < destList.getLength(); temp++) {
		
        Node dest = destList.item(temp);

        ////System.out.println("\nCurrent Element :" + dest.getNodeName());
 
		
        if (dest.getNodeType() == Node.ELEMENT_NODE) {
			
            Element eElement = (Element) dest;
                    
            if(dest.getNodeName().equals("CNPJ")){
                       if(dest.getTextContent().length()>50){
                           ////System.out.println("cnpj do cliente " + dest.getTextContent());
                            DCNPJ = dest.getTextContent().substring(0,50);
                       }else{
                            ////System.out.println("cnpj do cliente " + dest.getTextContent());
                            DCNPJ = dest.getTextContent();
                    
                       }
               
            }
		
        }
	
    }
     //-----------------------------TOTAL DE IMPOSTO ----------------------------------------------        
        
     NodeList ICMSTotList = doc.getElementsByTagName("ICMSTot").item(0).getChildNodes();
	
     ////System.out.println("ICMSTot----------------------------");
	
     for (int i = 0; i < ICMSTotList.getLength(); i++) {
		
         Node ICMSTot = ICMSTotList.item(i);

         ////System.out.println("\nCurrent Element :" + ICMSTot.getNodeName());
		
         if (ICMSTot.getNodeType() == Node.ELEMENT_NODE) {
			
             Element eElement = (Element) ICMSTot;

                if (ICMSTot.getNodeName().equals("vProd")){
                    if(ICMSTot.getTextContent().length()>30){
                        ////System.out.println("First Name : " + ICMSTot.getTextContent());
                        hnfe_valor_merc      = ICMSTot.getTextContent().substring(0,30);
                    }else{
                        ////System.out.println("First Name : " + ICMSTot.getTextContent());
                         hnfe_valor_merc      = ICMSTot.getTextContent();
                    }
                
                }else if(ICMSTot.getNodeName().equals("vNF")){        
                
                     if(ICMSTot.getTextContent().length()>30){
                        ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                        hnfe_valor_bruto     = ICMSTot.getTextContent().substring(0,30);
                    }else{
                        ////System.out.println("First Name : " + ICMSTot.getTextContent());
                        hnfe_valor_bruto     = ICMSTot.getTextContent();
                    }
                   
                }else if(ICMSTot.getNodeName().equals("vICMS")){             
                
                    if(ICMSTot.getTextContent().length()>30){
                        ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                        hnfe_valor_icms      = ICMSTot.getTextContent().substring(0,30);
                    
                    }else{
                        ////System.out.println("First Name : " + ICMSTot.getTextContent());
                        hnfe_valor_icms      = ICMSTot.getTextContent();
                    }
                  
                }else if(ICMSTot.getNodeName().equals("vBC")){             
                
                    if(ICMSTot.getTextContent().length()>30){
                       
                        hnfe_base_icms       = ICMSTot.getTextContent().substring(0,30);
                    }else{
                        ////System.out.println("First Name : " + ICMSTot.getTextContent());
                        hnfe_base_icms       = ICMSTot.getTextContent();
                    }
                      
                }else if(ICMSTot.getNodeName().equals("vIPI")){              
                
                    if(ICMSTot.getTextContent().length()>30){
                        ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                        hnfe_valor_ipi       = ICMSTot.getTextContent().substring(0,30);
                    }else{
                        ////System.out.println("First Name : " + ICMSTot.getTextContent());
                        hnfe_valor_ipi       = ICMSTot.getTextContent();
                    }
                       
                }else if(ICMSTot.getNodeName().equals("vDesc")){            
                
                    if(ICMSTot.getTextContent().length()>30){
                        ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                        hnfe_valor_desc      = ICMSTot.getTextContent().substring(0,30);
                    }else{
                         ////System.out.println("First Name : " + ICMSTot.getTextContent());
                        hnfe_valor_desc      = ICMSTot.getTextContent(); 
                    }
                    
                }else if(ICMSTot.getNodeName().equals("vFrete")){           
                
                    if(ICMSTot.getTextContent().length()>30){
                        ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                        hnfe_valor_frete     = ICMSTot.getTextContent().substring(0,30);
                    }else{
                        ////System.out.println("First Name : " + ICMSTot.getTextContent());
                        hnfe_valor_frete     = ICMSTot.getTextContent();
                    }   
                }else if(ICMSTot.getNodeName().equals("vOutro")){          
                
                       if(ICMSTot.getTextContent().length()>30){
                            ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                            hnfe_outras_despesas = ICMSTot.getTextContent().substring(0,30);
                        }else{
                            ////System.out.println("First Name : " + ICMSTot.getTextContent());
                            hnfe_outras_despesas = ICMSTot.getTextContent();
                        }
                        
                }else if(ICMSTot.getNodeName().equals("vBCST")){         
                
                       if(ICMSTot.getTextContent().length()>30){
                            ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                            hnfe_base_subst_trib = ICMSTot.getTextContent().substring(0,30);
                        }else{
                            ////System.out.println("First Name : " + ICMSTot.getTextContent());
                            hnfe_base_subst_trib = ICMSTot.getTextContent();
                        }
                }else if(ICMSTot.getNodeName().equals("vST")){         
                
                       if(ICMSTot.getTextContent().length()>30){
                            ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                            hnfe_valor_subst_trib = ICMSTot.getTextContent().substring(0,30);
                        }else{
                            ////System.out.println("First Name : " + ICMSTot.getTextContent());
                            hnfe_valor_subst_trib = ICMSTot.getTextContent();
                        }
                }else if(ICMSTot.getNodeName().equals("vPIS")){        
                
                       if(ICMSTot.getTextContent().length()>30){
                            ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                            hnfe_valor_pis       = ICMSTot.getTextContent().substring(0,30);
                        }else{
                            ////System.out.println("First Name : " + ICMSTot.getTextContent());
                            hnfe_valor_pis       = ICMSTot.getTextContent();
                        }
                   
                }else if(ICMSTot.getNodeName().equals("vCOFINS")){        
                
                       if(ICMSTot.getTextContent().length()>30){
                            ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                            hnfe_valor_cofins    = ICMSTot.getTextContent().substring(0,30);
                        }else{
                            ////System.out.println("First Name : " + ICMSTot.getTextContent());
                            hnfe_valor_cofins    = ICMSTot.getTextContent();
                        }
                }else if(ICMSTot.getNodeName().equals("vSeg")){     
                
                       if(ICMSTot.getTextContent().length()>30){
                            ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                            hnfe_valor_seguro    = ICMSTot.getTextContent().substring(0,30);
                        }else{
                            ////System.out.println("First Name : " + ICMSTot.getTextContent());
                            hnfe_valor_seguro    = ICMSTot.getTextContent();
                        }
                       
                }else if(ICMSTot.getNodeName().equals("vII")){         
                
                       if(ICMSTot.getTextContent().length()>30){
                            ////System.out.println("First Name : " + ICMSTot.getTextContent().substring(0,30));
                            hnfe_base_ipi        = ICMSTot.getTextContent().substring(0,30);
                        }else{
                            ////System.out.println("First Name : " + ICMSTot.getTextContent());
                            hnfe_base_ipi        = ICMSTot.getTextContent();
                        }
               
            }
        }
	
     }
     //-----------------------------NODE DE CHAVE ----------------------------------------------        
        NodeList infProtList = doc.getElementsByTagName("infProt").item(0).getChildNodes();

	// ////System.out.println("chave----------------------------");

	for (int temp = 0; temp < infProtList.getLength(); temp++) {

		Node infProt = infProtList.item(temp);

		// ////System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (infProt.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) infProt;
                    
                    if(infProt.getNodeName().equals("chNFe")){
                        if(infProt.getTextContent().length()>50){
                            //System.out.println("chave: " + infProt.getTextContent());
                            hnfe_chave = infProt.getTextContent().substring(0,50);
                        }else{
                            //System.out.println("chave: " + infProt.getTextContent());
                            hnfe_chave = infProt.getTextContent();
                        }
                        
                       
                    }
                    
                    if(infProt.getNodeName().equals("cStat")){
                        if(infProt.getTextContent().equalsIgnoreCase("100")){
                            
                        }else{
                                    if( (erro != 7) && (erro != 1) && (erro != 6) && (erro != 3)){
                                    
                                           erro = 10;
                                      }
                        }
                       
                    }

             }
                
	}
     
       //NodeList detList = doc.getElementsByTagName("prod").item(0).getChildNodes();
       //NodeList ICMSTAGList = doc.getElementsByTagName(doc.getElementsByTagName("det").item(0).getChildNodes().item(0).getNodeName()).item(0).getChildNodes();
       //// ////System.out.println(doc.getElementsByTagName("det").item(0).appendChild(doc));
      ////System.out.println("EU---------------------------------------------------------------------:"+doc.getElementsByTagName("det").item(0).getChildNodes().item(1).getNodeName());


 
 for (int i = 0; i < doc.getElementsByTagName("prod").getLength(); i++) { 
            
    
dnfe_nr_item.add(i,i + 1); 




prod_nbm.add(i,""); 

prod_isbn.add(i,""); 
prod_aliq_icm.add(i,""); 
prod_aliq_ipi.add(i,""); 
prod_aliq_iss.add(i,"");  
prod_aliq_csll.add(i,""); 
prod_aliq_cofins.add(i,""); 
prod_aliq_pis.add(i,"");  
prod_aliq_icms_st.add(i,"");  
prod_trib_cfop_prod.add(i,"");  
prod_cod_temp.add(i,""); 
dnfe_aliq_iss.add(i,"0.000"); 
dnfe_base_iss.add(i,"0.000"); 
dnfe_valor_iss.add(i,"0.000");  
dnfe_base_irr.add(i,"0.000"); 
dnfe_aliq_irr.add(i,"0.000"); 
dnfe_valor_irr.add(i,"0.000"); 
dnfe_trib_cfop_prod.add(i,""); 
dnfe_forma_trib_nfe.add(i,""); 
dnfe_valor_trib_icms.add(i,"0.000"); 
dnfe_valor_isento_icms.add(i,"0.000"); 
dnfe_valor_outras_icms.add(i,"0.000"); 
dnfe_valor_trib_ipi.add(i,"0.000"); 
dnfe_valor_isento_ipi.add(i,"0.000"); 
dnfe_valor_outras_ipi.add(i,"0.000"); 
dnfe_id_produto.add(i,""); 
dnfe_base_ipi.add(i,"");
dnfe_valor_ipi.add(i,"");
dnfe_aliq_ipi.add(i,"");
dnfe_ctipi.add(i,"");
dnfe_piscofins.add(i,"");
dnfe_valor_frete.add(i,"");
dnfe_outras_despesas.add(i,"0.000"); 
dnfe_ctrc.add(i,""); 
dnfe_prod_temp.add(i,""); 
dnfe_cod_cli_filial.add(i,""); 
dnfe_nf_situacao.add(i,""); 
dnfe_peso.add(i,""); 
dnfe_observacao.add(i,""); 
dnfe_ct.add(i,""); 
dnfe_situacao_piscofins.add(i,""); 


String P_prod_cod             = ""; 
String P_dnfe_cod_prod        = ""; 
String P_dnfe_cfop            = ""; 
String P_prod_descr           = ""; 
String P_dnfe_cod_descr       = ""; 
String P_prod_unid            = ""; 
String P_dnfe_unid_prod       = ""; 
String P_prod_quantidade      = ""; 
String P_dnfe_quantidade      = ""; 
String P_prod_valor_unitario  = ""; 
String P_dnfe_valor_unit      = ""; 
String P_prod_valor_total     = ""; 
String P_dnfe_valor_total     = ""; 
String P_dnfe_valor_frete     = ""; 
String P_dnfe_valor_desc      = ""; 
String P_dnfe_class_fiscal    = ""; 
String P_prod_class_fiscal    = ""; 
String P_prod_ncm             = ""; 
String P_dnfe_outras_despesas = "";

String P_dnfe_cod_cest                        = "";
boolean B_dnfe_cod_cest                       = false; 

boolean B_prod_cod             = false; 
boolean B_dnfe_cod_prod        = false; 
boolean B_dnfe_cfop            = false; 
boolean B_prod_descr           = false; 
boolean B_dnfe_cod_descr       = false; 
boolean B_prod_unid            = false; 
boolean B_dnfe_unid_prod       = false; 
boolean B_prod_quantidade      = false; 
boolean B_dnfe_quantidade      = false; 
boolean B_prod_valor_unitario  = false; 
boolean B_dnfe_valor_unit      = false; 
boolean B_prod_valor_total     = false; 
boolean B_dnfe_valor_total     = false; 
boolean B_dnfe_valor_frete     = false; 
boolean B_dnfe_valor_desc      = false; 
boolean B_dnfe_class_fiscal    = false; 
boolean B_prod_class_fiscal    = false; 
boolean B_prod_ncm             = false; 
boolean B_dnfe_outras_despesas = false; 

            NodeList produtos = doc.getElementsByTagName("det").item(i).getChildNodes().item(0).getChildNodes();

            ////System.out.println("----------------------------");

                    for (int j = 0; j < produtos.getLength(); j++) {
    
                        Node nProd = produtos.item(j);

                        //System.out.println("\nCurrent Element :" + nProd.getNodeName());

                        if (nProd.getNodeType() == Node.ELEMENT_NODE) {

                            Element eElement = (Element) nProd;
                            
                                                       //////System.out.println(nNode.getNodeName()+" : " + nNode.getTextContent());
                                if(nProd.getNodeName().equals("cProd")){ 
                                    
                                    if(nProd.getTextContent().length()>30){
                                        ////System.out.println("cProd : " + nProd.getTextContent().substring(0,30));
                                        P_prod_cod         = nProd.getTextContent().substring(0,30);
                                        P_dnfe_cod_prod    = nProd.getTextContent().substring(0,30);
                                      
                                    }else{
                                        ////System.out.println("cProd : " + nProd.getTextContent());
                                        P_prod_cod         = nProd.getTextContent();
                                        P_dnfe_cod_prod    = nProd.getTextContent();
                                       
                                    }
                                    B_prod_cod         = true; 
                                    B_dnfe_cod_prod    = true; 
                                   
                                }

else if(nProd.getNodeName().equals("CEST")){

   

   if(nProd.getTextContent().length()>30){

	   ////System.out.println("vOutro : " +  nProd.getTextContent().substring(0,30));

	   P_dnfe_cod_cest = nProd.getTextContent().substring(0,30);

	

   }else{

	   ////System.out.println("vOutro : " +  nProd.getTextContent());

	   P_dnfe_cod_cest = nProd.getTextContent();

	 

   }

  B_dnfe_cod_cest = true; 

                                }else if(nProd.getNodeName().equals("CFOP")){ 
                                       if(nProd.getTextContent().length()>30){
                                            ////System.out.println("CFOP : " +  nProd.getTextContent().substring(0,30));
                                            P_dnfe_cfop = nProd.getTextContent().substring(0,30);
                                           
                                       }else{
                                            ////System.out.println("CFOP : " +  nProd.getTextContent());
                                            P_dnfe_cfop = nProd.getTextContent();
                                           
                                       }
                                    B_dnfe_cfop = true; 
                                    
                                }else if(nProd.getNodeName().equals("xProd")){ 
                                       if(nProd.getTextContent().length()>30){
                                            ////System.out.println("CFOP : " +  nProd.getTextContent().substring(0,30));
                                            P_prod_descr = FormatarTexto.formater(nProd.getTextContent().substring(0,30));
                                           
                                       }else{
                                            ////System.out.println("CFOP : " +  nProd.getTextContent());
                                            P_prod_descr = FormatarTexto.formater(nProd.getTextContent());
                                           
                                       }
                                    B_prod_descr = true; 
                                    
                                }else if(nProd.getNodeName().equals("CFOP")){ 
                                       if(nProd.getTextContent().length()>30){
                                            ////System.out.println("CFOP : " +  nProd.getTextContent().substring(0,30));
                                            P_dnfe_cfop = nProd.getTextContent().substring(0,30);
                                           
                                       }else{
                                            ////System.out.println("CFOP : " +  nProd.getTextContent());
                                            P_dnfe_cfop = nProd.getTextContent();
                                           
                                       }
                                    B_dnfe_cfop = true; 
                                    
                                }else if(nProd.getNodeName().equals("vFrete")){ 
                                    if(nProd.getTextContent().length()>30){
                                        //System.out.println("vFrete : " + nProd.getTextContent().substring(0,250));
                                        P_dnfe_valor_frete = nProd.getTextContent().substring(0,30);
                                    }else{
                                        //System.out.println("vFrete : " + nProd.getTextContent());
                                        P_dnfe_valor_frete  = nProd.getTextContent();
                                    }
                                    
                                  
                                    B_dnfe_valor_frete = true; 
                                    
                                }else if(nProd.getNodeName().equals("uCom")){ 
                                    if(nProd.getTextContent().length()>30){
                                        ////System.out.println("uCom : " +  nProd.getTextContent().substring(0,30));
                                        P_prod_unid = P_dnfe_unid_prod = FormatarTexto.formater(nProd.getTextContent().substring(0,30));
                                                                              
                                    }else{
                                        ////System.out.println("uCom : " +  nProd.getTextContent());
                                        P_prod_unid = P_dnfe_unid_prod = FormatarTexto.formater(nProd.getTextContent());
                                    }
                                    
                                    B_prod_unid      = true; 
                                    B_dnfe_unid_prod = true;
                                  
                                }else if(nProd.getNodeName().equals("qCom")){ 
                                    if(nProd.getTextContent().length()>30){
                                        ////System.out.println("qCom : " + nProd.getTextContent().substring(0,30));
                                        P_prod_quantidade = nProd.getTextContent().substring(0,30);
                                        P_dnfe_quantidade = nProd.getTextContent().substring(0,30);
                                        
                                    }else{
                                        ////System.out.println("qCom : " + nProd.getTextContent());
                                        P_prod_quantidade = nProd.getTextContent();
                                        P_dnfe_quantidade = nProd.getTextContent();
                                        
                                    }
                                    
                                    B_prod_quantidade = true; 
                                    B_dnfe_quantidade = true; 
                                    
                                }else if(nProd.getNodeName().equals("vUnCom")){ 
                                    if(nProd.getTextContent().length()>30){
                                        ////System.out.println("vUnCom: " + nProd.getTextContent().substring(0,30));
                                       P_dnfe_valor_unit = P_prod_valor_unitario = nProd.getTextContent().substring(0,30);
                                            
                                       
                                    }else{
                                        ////System.out.println("vUnCom: " + nProd.getTextContent());
                                    P_dnfe_valor_unit = P_prod_valor_unitario = nProd.getTextContent();
                                        
                                    }
                                    B_prod_valor_unitario = true; 
                                    B_dnfe_valor_unit     = true; 
                                }else if(nProd.getNodeName().equals("vProd")){ 
                                    if(nProd.getTextContent().length()>30){
                                        ////System.out.println("vProd : " + nProd.getTextContent().substring(0,30));
                                        P_dnfe_valor_total = P_prod_valor_total = nProd.getTextContent().substring(0,30);
                                       
                                       
                                    }else{
                                       // //System.out.println("vProd : " + nProd.getTextContent());
                                       P_dnfe_valor_total = P_prod_valor_total  = nProd.getTextContent();
                                          
                                      
                                    }
                                    B_prod_valor_total = true; 
                                    B_dnfe_valor_total = true;  
                                }else if(nProd.getNodeName().equals("vDesc")){ 
                                    if(nProd.getTextContent().length()>30){
                                        ////System.out.println("vDesc : " + nProd.getTextContent().substring(0,30));
                                        P_dnfe_valor_desc = nProd.getTextContent().substring(0,30);
                                       
                                    }else{
                                        ////System.out.println("vDesc : " + nProd.getTextContent());
                                        P_dnfe_valor_desc = nProd.getTextContent();
                                       
                                    }
                                    B_dnfe_valor_desc = true; 
                                }else if(nProd.getNodeName().equals("NCM")){ 
                                    if(nProd.getTextContent().length()>30){
                                        ////System.out.println("NCM : " +  nProd.getTextContent().substring(0,30));
                                     P_prod_ncm  = P_prod_class_fiscal = P_dnfe_class_fiscal = nProd.getTextContent().substring(0,30);
                                        
                                        
                                    }else{
                                        ////System.out.println("NCM : " +  nProd.getTextContent());
                                   P_prod_ncm  = P_prod_class_fiscal = P_dnfe_class_fiscal = nProd.getTextContent();
                                       
                                    }
                                  
                                    B_dnfe_class_fiscal = true; 
                                    B_prod_class_fiscal = true; 
                                    B_prod_ncm          = true; 
                                   
                                }else if(nProd.getNodeName().equals("vOutro")){
                                    
                                    if(nProd.getTextContent().length()>30){
                                        ////System.out.println("vOutro : " +  nProd.getTextContent().substring(0,30));
                                        P_dnfe_outras_despesas = nProd.getTextContent().substring(0,30);
                                     
                                    }else{
                                        ////System.out.println("vOutro : " +  nProd.getTextContent());
                                        P_dnfe_outras_despesas = nProd.getTextContent();
                                      
                                    }
                                   B_dnfe_outras_despesas = true; 
                                }
                        }
                    }
                    
                    if(B_dnfe_outras_despesas == true){
                        
                        dnfe_outras_despesas.add(P_PROD, P_dnfe_outras_despesas);
                        
                    }else{
                        
                        dnfe_outras_despesas.add(P_PROD, "0.000");
                    }
                    if(B_dnfe_class_fiscal == true){
                        
                        dnfe_class_fiscal.add(P_PROD, P_dnfe_class_fiscal);
                        prod_class_fiscal.add(P_PROD, P_dnfe_class_fiscal);
                        prod_ncm.add(P_PROD, P_dnfe_class_fiscal);
                        
                    }else{
                        dnfe_class_fiscal.add(P_PROD, "");
                        prod_class_fiscal.add(P_PROD, "");
                        prod_ncm.add(P_PROD, "");
                    }
                    
                    if(B_dnfe_valor_desc == true){
                        dnfe_valor_desc.add(P_PROD,P_dnfe_valor_desc);
                    }else{
                        dnfe_valor_desc.add(P_PROD,"0.000");
                    }
                    
                    if(B_prod_valor_total == true){
                        prod_valor_total.add(P_PROD, P_prod_valor_total);
                        dnfe_valor_total.add(P_PROD, P_prod_valor_total);
                    }else{
                        prod_valor_total.add(P_PROD, "0.000");
                        dnfe_valor_total.add(P_PROD, "0.000");
                    }
                    
                    if(B_dnfe_valor_frete == true){
                        dnfe_valor_frete.add(P_PROD, P_dnfe_valor_frete);
                        
                    }else{
                        dnfe_valor_frete.add(P_PROD, "0.000");
                        
                    }
                    
                    if(B_prod_valor_unitario == true){
                        prod_valor_unitario.add(P_PROD, P_prod_valor_unitario);
                        dnfe_valor_unit.add(P_PROD, P_prod_valor_unitario);
                    }else{
                        prod_valor_unitario.add(P_PROD, "0.000");
                        dnfe_valor_unit.add(P_PROD, "0.000");
                    }
                    
                    if(B_prod_quantidade == true){
                        prod_quantidade.add(P_PROD, P_prod_quantidade);
                        dnfe_quantidade.add(P_PROD, P_prod_quantidade);
                    }else{
                        prod_quantidade.add(P_PROD, "0.000");
                        dnfe_quantidade.add(P_PROD, "0.000");
                    }
                    
                    if(B_prod_unid == true){
                        prod_unid.add(P_PROD, P_prod_unid);
                        dnfe_unid_prod.add(P_PROD, P_prod_unid);
                    }else{
                        prod_unid.add(P_PROD, "");
                        dnfe_unid_prod.add(P_PROD, "");
                    }
                   
                    if(B_prod_descr == true){
                        prod_descr.add(P_PROD,  P_prod_descr);
                        dnfe_cod_descr.add(P_PROD, P_prod_descr);
                    }else{
                        prod_descr.add(P_PROD,  "");
                        dnfe_cod_descr.add(P_PROD, "");
                    }
                    if(B_dnfe_cfop == true){
                        dnfe_cfop.add(P_PROD,  P_dnfe_cfop);
                    }else{
                         dnfe_cfop.add(P_PROD,  "");
                    }
                    
                    if(B_dnfe_cod_cest == true){

                        dnfe_cod_cest.add(P_PROD,  P_dnfe_cod_cest);

                    }else{

                        dnfe_cod_cest.add(P_PROD,  "");

                    }
                    
                    if(B_prod_cod == true){
                        prod_cod.add(P_PROD, P_prod_cod);
                        dnfe_cod_prod.add(P_PROD, P_prod_cod);
                        P_PROD++;
                    }
                    
                }
          //#######################################################################################
          
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	  for (int i = 0; i < doc.getElementsByTagName("prod").getLength(); i++) {
              
               boolean existe_tag_ipi = false;
                String IPI_vBC  = "0.000";
                String IPI_pIPI = "0.000";
                String IPI_vIPI = "0.000";
                String IPI_CST  = "";
                                
                boolean B_IPI_vBC  = false;
                boolean B_IPI_pIPI = false;
                boolean B_IPI_vIPI = false;
                boolean B_IPI_CST  = false;
              
            //corrrigi a posicao dos impostos
            int x = 0;
            int y = 0;
            int z = 0;
            int w = 0;
             
             int tag_tamanho = doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().getLength();
             String tag = doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(0).getNodeName();
             ////System.out.println("TAMANO DA TAG PAI DE IMPOSTO: " + doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().getLength());
             ////System.out.println("NOME DA TAG: " + doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(0).getNodeName());
             
             if((tag_tamanho < 4) && (tag.equalsIgnoreCase("ICMS"))){
                x = 0;
                y = 0;
                z = 1;
                w = 2;
                //System.out.println("if 1 X = 1; Y = 2; Z = 3; W = 4;" );
             }else if((tag_tamanho == 4) && (tag.equalsIgnoreCase("ICMS"))){
                x = 0;
                y = 1;
                z = 2;
                w = 3;
                //System.out.println("if 2 X = 1; Y = 2; Z = 3; W = 4;" );
             }else if((tag_tamanho == 4) && (tag.equalsIgnoreCase("vTotTrib"))){
                x = 1;
                y = 0;
                z = 2;
                w = 3;
                //System.out.println("if 3 X = 1; Y = 0; Z = 2; W = 3;" );
             }else if((tag_tamanho > 4) && (tag.equalsIgnoreCase("vTotTrib"))){
                x = 1;
                y = 2;
                z = 3;
                w = 4;
                //System.out.println("if 4 X = 1; Y = 2; Z = 3; W = 4;" );
             }
                          
             
            NodeList impostos = doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes();
            
              
                        

            ////System.out.println("----------------------------");

                    for (int j = 0; j < impostos.getLength(); j++) {
                      
                                            
                      
                       Node nNode = impostos.item(j);

                        ////System.out.println("\nCurrent Element :" + nNode.getNodeName());
//#######################################  ICMS   #########################################################################################################
                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element eElement = (Element) nNode;
                            
                            if(nNode.getNodeName().equals("ICMS")){ 
                                
                                ////System.out.println("\nCurrent Element :" + doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(1).getChildNodes().item(0).getNodeName());
                                                            
                                  
                                NodeList icms = doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(x).getChildNodes().item(0).getChildNodes();
                                
                                String ICMS_CST         = "0.000";
                        String ICMS_vBC         = "0.000";
                        String ICMS_pICMS       = "00.000";
                        String ICMS_vICMS       = "0.000";
                        String ICMS_vBCST       = "0.000";
                        String ICMS_vICMSST     = "0.000";
                        String ICMS_vBCSTRet    = "0.000";
                        String ICMS_vICMSSTRet  = "0.000";
                        String ICMS_pCredSN     = "00.000";
                        String ICMS_vCredICMSSN = "0.000";
                        String ICMS_CSOSN       = "0.000";
			String ICMS_VLR_BAS_FCP_RETIDO_ST    = "0.000"; 
                        String ICMS_PORCENTUAL_FCP_RETIDO_ST = "0.000"; 
                        String ICMS_VLR_FCP_RETIDO_ST        = "0.000";


			boolean B_ICMS_VLR_BAS_FCP_RETIDO_ST          = false; 
                        boolean B_ICMS_PORCENTUAL_FCP_RETIDO_ST       = false; 
                        boolean B_ICMS_VLR_FCP_RETIDO_ST              = false;  
                        
                        boolean B_ICMS_CST         = false;
                        boolean B_ICMS_vBC         = false;
                        boolean B_ICMS_pICMS       = false;
                        boolean B_ICMS_vICMS       = false;
                        boolean B_ICMS_vBCST       = false;
                        boolean B_ICMS_vICMSST     = false;
                        boolean B_ICMS_vBCSTRet    = false;
                        boolean B_ICMS_vICMSSTRet  = false;
                        boolean B_ICMS_pCredSN     = false;
                        boolean B_ICMS_vCredICMSSN = false;
                        boolean B_ICMS_CSOSN       = false;
                                
                                for(int k = 0;k < icms.getLength();k++){
                                 
                                    Node nICMS = icms.item(k);
                                    
                                    if (nICMS.getNodeType() == Node.ELEMENT_NODE) {
                                        
                                        Element eICMS = (Element) nICMS;
                            
                                                                                   
                                       /// ////System.out.println(nICMS.getNodeName()+" : " + nICMS.getTextContent());
                                        if(nICMS.getNodeName().equals("CST")){ 
                                            
                                            if(nICMS.getNodeName().length()>30){
                                               
                                                //System.out.println("CST :"+ nICMS.getTextContent().substring(0,30));
                                                ICMS_CST = nICMS.getTextContent().substring(0,30);
                                            
                                            }else{
                                                //System.out.println("CST :"+ nICMS.getTextContent());
                                                ICMS_CST = nICMS.getTextContent();
                                            }
                                            
                                         B_ICMS_CST  = true;
                                           
                                        }
                                        //FCP--------------------------------------------
 else if(nICMS.getNodeName().equals("vBCFCPST")){
   if(nICMS.getTextContent().length()>30){
	   ////System.out.println("vOutro : " +  nProd.getTextContent().substring(0,30));
	   ICMS_VLR_BAS_FCP_RETIDO_ST = nICMS.getTextContent().substring(0,30);
   }else{
	   ////System.out.println("vOutro : " +  nProd.getTextContent());
	   ICMS_VLR_BAS_FCP_RETIDO_ST = nICMS.getTextContent();
   }
  B_ICMS_VLR_BAS_FCP_RETIDO_ST = true; 
}else if(nICMS.getNodeName().equals("pFCPST")){
   if(nICMS.getTextContent().length()>30){
	   ////System.out.println("vOutro : " +  nProd.getTextContent().substring(0,30));
	   ICMS_PORCENTUAL_FCP_RETIDO_ST = nICMS.getTextContent().substring(0,30);
   }else{
	   ////System.out.println("vOutro : " +  nProd.getTextContent());
	   ICMS_PORCENTUAL_FCP_RETIDO_ST = nICMS.getTextContent();
   }
  B_ICMS_PORCENTUAL_FCP_RETIDO_ST = true; 
}else if(nICMS.getNodeName().equals("vFCPST")){
   if(nICMS.getTextContent().length()>30){
	   ////System.out.println("vOutro : " +  nProd.getTextContent().substring(0,30));
	   ICMS_VLR_FCP_RETIDO_ST = nICMS.getTextContent().substring(0,30);
   }else{
	   ////System.out.println("vOutro : " +  nProd.getTextContent());
	   ICMS_VLR_FCP_RETIDO_ST = nICMS.getTextContent();
   }
  B_ICMS_VLR_FCP_RETIDO_ST = true; 
}
                                        //FCP--------------------------------------------       
                                        else if(nICMS.getNodeName().equals("vBC")){                
                                            if(nICMS.getNodeName().length()>30){
                                               
                                                ////System.out.println("base : " + nICMS.getTextContent().substring(0,30));
                                                 ICMS_vBC = nICMS.getTextContent().substring(0,30); 
                                            }else{
                                               
                                                ////System.out.println("base : " + nICMS.getTextContent());
                                                ICMS_vBC = nICMS.getTextContent(); 
                                            }
                                            ////System.out.println("vBC : " + nICMS.getTextContent());
                                            B_ICMS_vBC  = true;
                                        }else if(nICMS.getNodeName().equals("pICMS")){    
                                            if(nICMS.getNodeName().length()>30){
                                              
                                                ////System.out.println("aliquota : " + nICMS.getTextContent().substring(0,30));
                                                ICMS_pICMS = nICMS.getTextContent().substring(0,30);
                                            }else{
                                                ////System.out.println("aliquota : " + nICMS.getTextContent());
                                                ICMS_pICMS =nICMS.getTextContent();
                                            }
                                            ////System.out.println("pICMS : " + nICMS.getTextContent());
                                           B_ICMS_pICMS  = true;
                       
                                        }else if(nICMS.getNodeName().equals("vICMS")){    
                                            if(nICMS.getNodeName().length()>30){
                                                
                                                ////System.out.println("valor vICMS: " + nICMS.getTextContent().substring(0,30));
                                                ICMS_vICMS = nICMS.getTextContent().substring(0,30);
                                            }else{
                                              
                                                ////System.out.println("valor vICMS: " + nICMS.getTextContent());
                                                ICMS_vICMS = nICMS.getTextContent();
                                            }
                                           // //System.out.println("valor vICMS: " + nICMS.getTextContent());
                                            B_ICMS_vICMS = true;
                     
                                            
                                        }else if(nICMS.getNodeName().equals("vBCST")){
                                            
                                            if(nICMS.getNodeName().length()>30){
                                                
                                                ////System.out.println("vBCST : " + nICMS.getTextContent().substring(0,30));
                                                ICMS_vBCST = nICMS.getTextContent().substring(0,30);
                                            }else{
                                                
                                                ////System.out.println("vBCST : " + nICMS.getTextContent());
                                                ICMS_vBCST = nICMS.getTextContent();
                                            }
                                            B_ICMS_vBCST = true;
                      
                                        }else if(nICMS.getNodeName().equals("vICMSST")){  
                                             
                                            if(nICMS.getNodeName().length()>30){
                                                
                                                ////System.out.println("valor vICMSST: " + nICMS.getTextContent().substring(0,30));
                                                ICMS_vICMSST =  nICMS.getTextContent().substring(0,30);
                                            }else{
                                                ////System.out.println("valor vICMSST: " + nICMS.getTextContent());
                                                ICMS_vICMSST = nICMS.getTextContent();
                                             }
                                            B_ICMS_vICMSST = true;
                                          
                                        }else if(nICMS.getNodeName().equals("vBCSTRet")){    
                                            
                                            if(nICMS.getNodeName().length()>30){
                                                ////System.out.println("valor vBCSTRet: " + nICMS.getTextContent().substring(0,30));
                                                ICMS_vBCSTRet = nICMS.getTextContent().substring(0,30);
                                            }else{
                                                
                                                ////System.out.println("valor vBCSTRet: " + nICMS.getTextContent());
                                                ICMS_vBCSTRet = nICMS.getTextContent();
                                            }
                                            B_ICMS_vBCSTRet = true;
                                           
                                        }else if(nICMS.getNodeName().equals("vICMSSTRet")){    
                                            
                                            if(nICMS.getNodeName().length()>30){
                                               
                                                ////System.out.println("valor : vICMSSTRet " + nICMS.getTextContent().substring(0,30));
                                                ICMS_vICMSSTRet = nICMS.getTextContent().substring(0,30);
                                            }else{
                                                ////System.out.println("valor : vICMSSTRet " + nICMS.getTextContent());
                                                ICMS_vICMSSTRet = nICMS.getTextContent();
                                            }
                                            B_ICMS_vICMSSTRet  = true;
                                            
                                        } else if(nICMS.getNodeName().equals("pCredSN")){ 
                                            
                                            if(nICMS.getNodeName().length()>30){
                                            
                                                ////System.out.println("pCredSN : " + nICMS.getTextContent().substring(0,30));
                                                ICMS_pCredSN = nICMS.getTextContent().substring(0,30);
                                            
                                            }else{
                                            
                                                ////System.out.println("pCredSN : " + nICMS.getTextContent());
                                                ICMS_pCredSN = nICMS.getTextContent();
                                            }
                                           B_ICMS_pCredSN = true;
                                          
                                        }else if(nICMS.getNodeName().equals("vCredICMSSN")){    
                                            
                                            if(nICMS.getNodeName().length()>30){
                                                ////System.out.println("valor vCredICMSSN: " + nICMS.getTextContent().substring(0,30));
                                                ICMS_vCredICMSSN = nICMS.getTextContent().substring(0,30);
                                            }else{
                                               
                                                ////System.out.println("valor vCredICMSSN: " + nICMS.getTextContent());
                                                ICMS_vCredICMSSN = nICMS.getTextContent();
                                            }
                                            B_ICMS_vCredICMSSN = true;
                                            
                                        }else if(nICMS.getNodeName().equals("CSOSN")){ 
                                            
                                            if(nICMS.getNodeName().length()>30){
                                                
                                                //System.out.println("CSOSN :"+ nICMS.getTextContent().substring(0,30));
                                                ICMS_CSOSN = nICMS.getTextContent().substring(0,30);
                                            }else{
                                                
                                                //System.out.println("CSOSN :"+ nICMS.getTextContent());
                                                ICMS_CSOSN = nICMS.getTextContent();
                                            }
                                            
                                            B_ICMS_CSOSN = true;
                                        }
                                       
                                    }
                                 }
                                   
                                    if(B_ICMS_vBC==true){
                                        dnfe_base_icm.add(C_ICMS,ICMS_vBC);
                                   }else{
                                       dnfe_base_icm.add(C_ICMS,"0.000");
                                   } 
                                     if(B_ICMS_pICMS==true){
                                        dnfe_aliq_icm.add(C_ICMS,ICMS_pICMS);
                                   }else{
                                       dnfe_aliq_icm.add(C_ICMS,"0.000");
                                   }
                                     if(B_ICMS_vICMS==true){
                                       dnfe_valor_icm.add(C_ICMS,ICMS_vICMS);
                                   }else{
                                       dnfe_valor_icm.add(C_ICMS,"00.000");
                                   }
                                    if(B_ICMS_vBCST==true){
                                        dnfe_base_subst_trib.add(C_ICMS,ICMS_vBCST);
                                   }else{
                                       dnfe_base_subst_trib.add(C_ICMS,"0.000");
                                   } 
                                     if(B_ICMS_vICMSST==true){
                                        dnfe_valor_subst_trib.add(C_ICMS,ICMS_vICMSST);
                                   }else{
                                       dnfe_valor_subst_trib.add(C_ICMS,"0.000");
                                   }
                                     if(B_ICMS_vBCSTRet==true && Double.parseDouble(ICMS_vBCSTRet)>0){
                                       dnfe_base_subst_trib.add(C_ICMS,ICMS_vBCSTRet);
                                   }
                                    if(B_ICMS_vICMSSTRet==true && Double.parseDouble(ICMS_vICMSSTRet)>0){
                                        dnfe_valor_subst_trib.add(C_ICMS,ICMS_vICMSSTRet);
                                   }
                                     if(B_ICMS_pCredSN==true &&  Double.parseDouble(ICMS_pCredSN)>0){
                                        dnfe_aliq_icm.add(C_ICMS,ICMS_pCredSN);
                                   }
                                     if(B_ICMS_vCredICMSSN==true && Double.parseDouble( ICMS_vCredICMSSN)>0){
                                       dnfe_valor_icm.add(C_ICMS,ICMS_vCredICMSSN);
                                   }
                                     /***********fcp*************/
                                     if(B_ICMS_VLR_BAS_FCP_RETIDO_ST == true){
                                            dnfe_vlr_bas_fcp_retido_st.add(C_ICMS,  ICMS_VLR_BAS_FCP_RETIDO_ST);
                                    }else{
                                            dnfe_vlr_bas_fcp_retido_st.add(C_ICMS,  "");
                                    }
                                     if(B_ICMS_PORCENTUAL_FCP_RETIDO_ST == true){
                                        dnfe_porcentual_fcp_retido_st.add(C_ICMS,  ICMS_PORCENTUAL_FCP_RETIDO_ST);
                                    }else{
                                            dnfe_porcentual_fcp_retido_st.add(C_ICMS,  "");
                                    }
                                    if(B_ICMS_VLR_FCP_RETIDO_ST == true){
                                        dnfe_vlr_fcp_retido_st.add(C_ICMS,  ICMS_VLR_FCP_RETIDO_ST);
                                    }else{
                                         dnfe_vlr_fcp_retido_st.add(C_ICMS,  "");
                                    }
                                    /***********fcp*************/ 
                                     if(B_ICMS_CST == true){
                                        dnfe_cod_trib.add(C_ICMS,ICMS_CST);
                                        C_ICMS++;
                                     }
                                     if(B_ICMS_CSOSN==true){
                                        dnfe_cod_trib.add(C_ICMS,ICMS_CSOSN);
                                        C_ICMS++;
                                    }
                             }//-------------------------fim do ICMS
//#######################################  IPI   #########################################################################################################
                            else  if(nNode.getNodeName().equals("IPI")){
                                existe_tag_ipi = true;
                                ///corrige a posição do ipi
                                int pi =0;
                                
                                int tag_ipi_tam = doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(y).getChildNodes().getLength();
                                ////System.out.println("TAMNAHO DA TAG DE IPI : " + doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(y).getChildNodes().item(pi).getNodeName());
                              ////System.out.println("case : " + doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(1).getNodeName();
                                //System.out.println("case : " + doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(y).getNodeName());  
                                                          
                                if(tag_ipi_tam == 1){
                                    pi=0;
                                }else{
                                    pi= tag_ipi_tam - 1; 
                                }
                                //------------------//
                                
                             NodeList IPI = doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(y).getChildNodes().item(pi).getChildNodes();
                                
                           
                  
                                for(int k = 0;k < IPI.getLength();k++){
                                    
                               
                                    Node nIPI = IPI.item(k);
                                    
                                    if (nIPI.getNodeType() == Node.ELEMENT_NODE) {
                                        
                                        Element eIPI = (Element) nIPI;
                                       
                                            
                                        //////System.out.println(nIPI.getNodeName()+" : " + nIPI.getTextContent());
                                    
                                    

                                        if(nIPI.getNodeName().equals("vBC")){ 
                                            
                                            if(nIPI.getTextContent().length()>30){
                                           
                                                IPI_vBC  = nIPI.getTextContent().substring(0,30);
                                                
                                            }else{
                                            
                                                IPI_vBC  = nIPI.getTextContent();
                                                
                                            }
                                        B_IPI_vBC  = true;
                                  //      //System.out.println("IPI vBC : " + nIPI.getTextContent());
                                           
                                        }else if(nIPI.getNodeName().equals("pIPI")){ 
                                            if(nIPI.getTextContent().length()>30){
                                            
                                                IPI_pIPI  = nIPI.getTextContent().substring(0,30);
                                                
                                            }else{
                                               
                                                IPI_pIPI  = nIPI.getTextContent();
                                           
                                            }
                                        B_IPI_pIPI = true;
                                // //System.out.println("pIPI : " + nIPI.getTextContent());
                                
                                         }else if(nIPI.getNodeName().equals("vIPI")){ 
                                            if(nIPI.getTextContent().length()>30){
                                            
                                                IPI_vIPI  = nIPI.getTextContent().substring(0,30);
                                                
                                            }else{
                                            
                                                IPI_vIPI  = nIPI.getTextContent();
                                            }
                                         B_IPI_vIPI = true;
                             //System.out.println("vIPI : " + nIPI.getTextContent());
                                         }else if(nIPI.getNodeName().equals("CST")){ 
                                            if(nIPI.getTextContent().length()>30){
                                               
                                                 IPI_CST  = nIPI.getTextContent().substring(0,30);
                                                
                                            }else{
                                            
                                                IPI_CST  = nIPI.getTextContent();
                                            }
                                          B_IPI_CST  = true;  
                                          // //System.out.println("IPI CST : " + nIPI.getTextContent());
                                           
                                        }
                                        
                                    }
                                
                                 }
                                
                                  if(B_IPI_vBC==true&&existe_tag_ipi==true){
                                     dnfe_base_ipi.add(C_IPI,IPI_vBC);
                                     B_IPI_vBC=false;
                                }else{
                                    dnfe_base_ipi.add(C_IPI,"0.000");
                                     B_IPI_vBC=false;
                                } 
                                  if(B_IPI_vIPI==true&&existe_tag_ipi==true){
                                     dnfe_valor_ipi.add(C_IPI,IPI_vIPI);
                                      B_IPI_vIPI=false;
                                }else{
                                    dnfe_valor_ipi.add(C_IPI,"0.000");
                                    B_IPI_vIPI=false;
                                }
                                  if(B_IPI_pIPI==true&&existe_tag_ipi==true){
                                    dnfe_aliq_ipi.add(C_IPI,IPI_pIPI);
                                    B_IPI_pIPI=false;
                                }else{
                                    dnfe_aliq_ipi.add(C_IPI,"00.00");
                                    B_IPI_pIPI=false;
                                }
                                  if(B_IPI_CST==true&&existe_tag_ipi==true){
                                    B_IPI_CST=false;
                                    dnfe_ctipi.add(C_IPI,IPI_CST);
                                    C_IPI++;
                                }
                              
                                                            
                            
                            }//-----------------------fim da tag IPI
//#######################################   PIS   #########################################################################################################
                             else  if(nNode.getNodeName().equals("PIS")){
                            
                             NodeList PIS = doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(z).getChildNodes().item(0).getChildNodes();
                                   String PIS_vBC  = "0.000";
                                   // String PIS_pIPI = "0.000";
                                    String PIS_vPIS = "0.000";
                                    String PIS_CST  = "";
                                    boolean B_PIS_vBC  = false;
                                    boolean B_PIS_vPIS  = false;
                                    boolean B_PIS_CST   = false;
                                for(int k = 0;k < PIS.getLength();k++){
                                  
                                 
                                    Node nPIS = PIS.item(k);
                                    
                                    if (nPIS.getNodeType() == Node.ELEMENT_NODE) {
                                        
                                        Element ePIS = (Element) nPIS;
                            
                                          
                                            
                                        //////System.out.println(nPIS.getNodeName()+" : " + nPIS.getTextContent());
                                        
                                     
                                        if(nPIS.getNodeName().equals("vBC")){
                                            
                                            if(nPIS.getTextContent().length()>30){
                                                
                                                PIS_vBC  = nPIS.getTextContent().substring(0,30);
                                           
                                            
                                            }else{
                                              
                                                PIS_vBC  = nPIS.getTextContent();
                                              
                                            }
                                            B_PIS_vBC  = true;
                                   
                                        }else if(nPIS.getNodeName().equals("vPIS")){
                                            if(nPIS.getTextContent().length()>30){
                                                
                                                PIS_vPIS  = nPIS.getTextContent().substring(0,30);
                                             
                                            }else{
                                              
                                                PIS_vPIS  = nPIS.getTextContent();
                                               
                                            }
                                        B_PIS_vPIS  = true;
                                   
                                        }else if(nPIS.getNodeName().equals("CST")){  
                                            if(nPIS.getTextContent().length()>30){
                                               
                                                PIS_CST  = nPIS.getTextContent().substring(0,30);
                                              
                                            }else{
                                               
                                                 PIS_CST  = nPIS.getTextContent();
                                               
                                            }
                                          B_PIS_CST   = true;
                                        }
                                    }
                                  
                                 }
                                
                                 if(B_PIS_vBC==true){
                                   dnfe_base_pis.add(C_PIS,PIS_vBC);
                                }else{
                                    dnfe_base_pis.add(C_PIS,"0.000");
                                } if(B_PIS_vPIS==true){
                                    dnfe_valor_pis.add(C_PIS,PIS_vPIS);
                                }else{
                                    dnfe_valor_pis.add(C_PIS,"0.000");
                                } if(B_PIS_CST==true){
                                  dnfe_codtrib_pis.add(C_PIS,PIS_CST);
                                    C_PIS++;
                                }
                            
                            }//--------------fim da tag PIS
//#######################################  COFINS   #########################################################################################################
                            else  if(nNode.getNodeName().equals("COFINS")){
                      
                        
                             NodeList COFINS = doc.getElementsByTagName("det").item(i).getChildNodes().item(1).getChildNodes().item(w).getChildNodes().item(0).getChildNodes();
                                    
                                    String COFINS_vBC  = "0.000";
                                    //String PIS_pIPI = "0.000";
                                    String COFINS_vCOFINS = "0.000";
                                    String COFINS_CST  = "";
                                    boolean B_COFINS_vBC  = false;
                                    boolean B_COFINS_vCOFINS = false;
                                    boolean B_COFINS_CST  = false;
                                    
                                for(int k = 0;k < COFINS.getLength();k++){
                                 
                                    Node nCOFINS = COFINS.item(k);
                                    
                                    if (nCOFINS.getNodeType() == Node.ELEMENT_NODE) {
                                        
                                        Element eCOFINS = (Element) nCOFINS;
                            
                                        ////System.out.println(nCOFINS.getNodeName()+" : " + nCOFINS.getTextContent() + hnfe_chave);
                                        
                                        if(nCOFINS.getNodeName().equals("vBC")){
                                            
                                            if(nCOFINS.getTextContent().length()>30){
                                                
                                              
                                                COFINS_vBC  = nCOFINS.getTextContent().substring(0,30); 
                                             
                                            
                                            }else{
                                            
                                               
                                                COFINS_vBC  = nCOFINS.getTextContent(); 
                                            
                                            }
                                          B_COFINS_vBC  = true;
                                   
                                        }else if(nCOFINS.getNodeName().equals("pCOFINS")){   
                                        ////System.out.println("base : " + nCOFINS.getTextContent());

                                         }else if(nCOFINS.getNodeName().equals("vCOFINS")){
                                            if(nCOFINS.getTextContent().length()>30){
                                               
                                                COFINS_vCOFINS  = nCOFINS.getTextContent().substring(0,30); 
                                         
                                            }else{
                                               
                                                COFINS_vCOFINS  = nCOFINS.getTextContent(); 
                                                
                                            }
                                            //String PIS_pIPI = "0.000";
                                             B_COFINS_vCOFINS = true;
                                   
                                         }else if(nCOFINS.getNodeName().equals("CST")){
                                            if(nCOFINS.getTextContent().length()>30){
                                               
                                                COFINS_CST  = nCOFINS.getTextContent().substring(0,30); 
                                              
                                            }else{
                                            
                                                COFINS_CST  = nCOFINS.getTextContent(); 
                                                
                                            }
                                               B_COFINS_CST  = true;
                                        }
                                    }
                                 }
                             
                                if(B_COFINS_vBC == true){
                                    dnfe_base_cofins.add(CFS,COFINS_vBC);
                                }else{
                                    dnfe_base_cofins.add(CFS,"0.000");
                                } if(B_COFINS_vCOFINS ==true){
                                    dnfe_valor_cofins.add(CFS,COFINS_vCOFINS);
                                }else{
                                    dnfe_valor_cofins.add(CFS,"0.000");
                                } if(B_COFINS_CST == true){
                                    dnfe_codtrib_cofins.add(CFS,COFINS_CST);
                                    CFS++;
                                }
                                
                               
                                                             
                            }//--------------fim da tag COFINS
                        }
                    }
                    
                                if(B_IPI_vBC == false && existe_tag_ipi == false){
                                     dnfe_base_ipi.add(C_IPI,"0.000");
                                }
                                  if(B_IPI_vIPI == false && existe_tag_ipi == false){
                                     dnfe_valor_ipi.add(C_IPI,"0.000");
                                }
                                  if(B_IPI_pIPI == false && existe_tag_ipi == false){
                                    dnfe_aliq_ipi.add(C_IPI,"00.00");
                                }
                                  if(B_IPI_CST == false && existe_tag_ipi == false){
                                   dnfe_ctipi.add(C_IPI,"");
                                   C_IPI++;
                                }
                               
                }
          //#######################################################################################
                
 }else{
                            erro = 6;
                            Node nChaveE = doc.getElementsByTagName(doc.getDocumentElement().getNodeName()).item(0).getChildNodes().item(0).getChildNodes().item(0);
                            Element eChaveE = (Element) nChaveE;
                            File log_chave_load = new File(diretorio+"\\CHAVE.txt");
                            FileOutputStream log_nf_chave = new FileOutputStream(log_chave_load,true);
 
                            BufferedWriter tipo_nota = new BufferedWriter(new OutputStreamWriter(log_nf_chave));
                            tipo_nota.write("Tipo de nota : " + doc.getDocumentElement().getNodeName().substring(0,3)+" CHAVE: " + tipo_chave +" Posicao: " + xml_pos);
                            tipo_nota.newLine();
                            tipo_nota.close();
                            
                            try {
              
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chave.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Image image = new Image("/loki/source/loki.png");
                    Stage stage = new Stage();
                    stage.setTitle("Loki 3.00");
                    stage.getIcons().add(image);
                    stage.setScene(new Scene(root1));  
                    stage.show();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
                            
        } 
 } catch (Exception e) {
                            e.printStackTrace();
            
                            File log_erro_xml = new File(diretorio+"\\ERRO_LEITURA.txt");
                            FileOutputStream log_file_erro_xml = new FileOutputStream(log_erro_xml,true);
 
                            BufferedWriter bwerro_xml = new BufferedWriter(new OutputStreamWriter(log_file_erro_xml));
                            bwerro_xml.write("Erro de Leitura: " + e.getMessage()+" CHAVE: "+ hnfe_chave+ " Posicao:" + xml_pos);
                            bwerro_xml.newLine();
                            bwerro_xml.close();
                            erro = 3;
                            
                try {
              
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("erro.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Image image = new Image("/loki/source/loki.png");
                    Stage stage = new Stage();
                    stage.setTitle("Loki 3.00");
                    stage.getIcons().add(image);
                    stage.setScene(new Scene(root1));  
                    stage.show();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
        }
 
                 
 //-------------------------------sql----------------------
    
  
 try {
		Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			// ////System.out.println("Where is your PostgreSQL JDBC Driver? "+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

 
		// ////System.out.println("PostgreSQL JDBC Driver Registered!");

		 connection = null;
                //Statement stmt = null;
            
                             
                
              
		try {
			//LOCAL
			//connection = DriverManager.getConnection("jdbc:postgresql://localhost:5435/bpmware", "operador","integra3070");
		        //SERVIDOR
                        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/bpmware", "operador","integra3070");
                        //CASA
                        //connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/bpmware", "operador","integra3070");
		
                        if (connection != null && tipo_nota == 0 && hnfe_chave.length()>0 && P_PROD>0) {
                    
			// ////System.out.println("You made it, take control your database now!");
                        Query  ="SELECT CLI_NM_CLIENTE ,CLI_ID_CLIENTE FROM THOR.BPM_CLI_CLIENTE WHERE cli_cnpj = ? AND SUBSTRING(CLI_ID_CLIENTE FROM (length(CLI_ID_CLIENTE)-2) FOR length(CLI_ID_CLIENTE))<>'NFS';";
                        PreparedStatement Select_Cnpj = null;
                        Select_Cnpj = connection.prepareStatement(Query);
                        Select_Cnpj.setString(1, DCNPJ);
                        ResultSet R_cnpj = Select_Cnpj.executeQuery();
                      
                        if (R_cnpj.next()) {
                               
                               
                                bpm_id_cliente = R_cnpj.getString("CLI_ID_CLIENTE");
                                forn_cod_empresa = prod_cod_empresa = hnfe_cod_empresa = dnfe_cod_empresa = R_cnpj.getString("CLI_NM_CLIENTE").replace(" ", "");
                                bpm_id_cliente = bpm_id_cliente.replace("NFS", "");
                                bpm_id_cliente = bpm_id_cliente.replace(" ", "");
                            }else{
                              if( (erro != 7) || (erro != 10) || (erro != 6) || (erro != 3)){
                                    
                                           erro = 1;
                                           //System.out.println("sem cliente cadastrado");
                                      }
                          
                          
                          }
                          R_cnpj.close();
                          if(bpm_id_cliente.equals("")|| dnfe_cod_empresa.equals("")){
                                   if( (erro != 7) && (erro != 10) && (erro != 6) && (erro != 3)){
                                    
                                           erro = 1;
                                           //System.out.println("bpm_id_cliente ou dnfe_cod_empresa vazio ");
                                      }
                            
                          }else{
                              if( (erro != 7) && (erro != 10) && (erro != 1)&& (erro != 6) && (erro != 3)){
                                    
                                           erro = 0;
                                      }
                            
                          }
                        Query  ="SELECT FORN_COD_CLI  FROM thor.cad_fornec WHERE FORN_COD_CLI = ? and bpm_id_cliente = ? and FORN_COD_EMPRESA = ?;";
                        PreparedStatement Select_Forn = null;
                        Select_Forn = connection.prepareStatement(Query);
                        Select_Forn.setString(1, forn_cod_cli);
                        Select_Forn.setString(2, bpm_id_cliente);
                        Select_Forn.setString(3, hnfe_cod_empresa);
                        ResultSet R_Forn = Select_Forn.executeQuery();
                      
                        if (R_Forn.next()) {
                               
                                forn_erro = 1;
                              
                            }else{
                                forn_erro = 0;
                          
                          
                          }
                        R_Forn.close();
                          ////System.out.println(bpm_id_cliente);
                          ////System.out.println( "codigo do cliente: "+prod_cod_empresa +" "+ hnfe_cod_empresa+" "+ dnfe_cod_empresa);
                          
                          Query = "SELECT hnfe_chave FROM THOR.HEADER_NFE_THOR   WHERE bpm_id_cliente = ? AND hnfe_chave = ?;";  
                           
                          PreparedStatement Select_chave = null;
                          
                           Select_chave = connection.prepareStatement(Query);
                           Select_chave.setString(1, bpm_id_cliente);
                           Select_chave.setString(2, hnfe_chave);
                           ResultSet R_nf = Select_chave.executeQuery();
                           
                            if (R_nf.next()) {
                                      ////System.out.println( R_nf.getString("hnfe_chave"));
                                      if( (erro != 7) && (erro != 10) && (erro != 1) && (erro != 6) && (erro != 3)){
                                    
                                           erro = 2;
                                      }
                            }
                        
                          R_nf.close();
                          if(erro == 1 ){
                            ////System.out.println("EMPRESA not cadastrada");
                            File log_file = new File(diretorio+"\\Log.txt");
                            FileOutputStream log = new FileOutputStream(log_file,true);
 
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(log));
                            bw.write("CNPJ NÃO CADASTRADO :" + DCNPJ + " CHAVE: "+ hnfe_chave +" Posicao: " + + xml_pos);
                            bw.newLine();
                            bw.close();
                          }
                          else if(erro == 2 ){
                            ////System.out.println("\nNota ja inserida na base!");
                            File log_file_nota = new File(diretorio+"\\Log.txt");
                            FileOutputStream log_nf = new FileOutputStream(log_file_nota,true);
 
                            BufferedWriter bwn = new BufferedWriter(new OutputStreamWriter(log_nf));
                            //bwn.write("codigo municipal            : " + forn_cod_municipio + " Posicao: " + + xml_pos);
                            bwn.write("CHAVE JA INTEGRADA          :" + hnfe_chave+" Posicao: " + + xml_pos);
                            bwn.newLine();
                            bwn.close();
                        }else if(erro == 10 ){
                            ////System.out.println("\nNota ja inserida na base!");
                            File log_file_nota = new File(diretorio+"\\Log.txt");
                            FileOutputStream log_nf = new FileOutputStream(log_file_nota,true);
 
                            BufferedWriter bwn = new BufferedWriter(new OutputStreamWriter(log_nf));
                            //bwn.write("codigo municipal            : " + forn_cod_municipio + " Posicao: " + + xml_pos);
                            bwn.write("CHAVE                       :" + hnfe_chave+" CANCELADA OU INUTILIZADA");
                            bwn.newLine();
                            bwn.close();
                        }else if(erro == 7 ){
                            ////System.out.println("\nNota ja inserida na base!");
                            File log_file_nota = new File(diretorio+"\\Log.txt");
                            FileOutputStream log_nf = new FileOutputStream(log_file_nota,true);
 
                            BufferedWriter bwn = new BufferedWriter(new OutputStreamWriter(log_nf));
                            //bwn.write("codigo municipal            : " + forn_cod_municipio + " Posicao: " + + xml_pos);
                            bwn.write("CHAVE                       :" + hnfe_chave+" ENTRADA DE EMISSAO PROPRIA");
                            bwn.newLine();
                            bwn.close();
                        }  else if(erro == 0){
                           
                        qtchaves++;
                        Query = "INSERT INTO thor.cad_fornec(forn_cod_empresa, forn_cod_cli, forn_pess_fj, forn_ecliente, forn_efornecedor, forn_nome, forn_nomered, forn_tipo_forn, forn_endereco, forn_numero, forn_municipio, forn_estado, forn_natureza, forn_bairro, forn_cep, forn_ddi, forn_ddd, forn_tel, forn_fax, forn_cgc, forn_inscrmunicial, forn_cpf, forn_ie, forn_rg, forn_email, forn_rec_cofins, forn_rec_csll, forn_rec_pis, forn_contribuinte, bpm_dt_criacao, bpm_id_cliente, forn_tipo_cli, forn_cod_efiscal, forn_cod_municipio, forn_nm_munic_corr, forn_cgc_dig, forn_pais, forn_cod_pais) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";  
                        
                        if( forn_erro == 0 ){
                        
                            PreparedStatement Insert_Fornecedor = null;
                        
                        Insert_Fornecedor = connection.prepareStatement(Query);
                        
                        Insert_Fornecedor.setString(1,forn_cod_empresa);
                        Insert_Fornecedor.setString(2,forn_cod_cli);
                        Insert_Fornecedor.setString(3,forn_pess_fj);
                        Insert_Fornecedor.setString(4,forn_ecliente);
                        Insert_Fornecedor.setString(5,forn_efornecedor);
                        Insert_Fornecedor.setString(6,forn_nome);
                        Insert_Fornecedor.setString(7,forn_nomered);
                        Insert_Fornecedor.setString(8,forn_tipo_forn);
                        Insert_Fornecedor.setString(9,forn_endereco);
                        Insert_Fornecedor.setString(10,forn_numero);
                        Insert_Fornecedor.setString(11,forn_municipio);
                        Insert_Fornecedor.setString(12,forn_estado);
                        Insert_Fornecedor.setString(13,forn_natureza);
                        Insert_Fornecedor.setString(14,forn_bairro);
                        Insert_Fornecedor.setString(15,forn_cep);
                        Insert_Fornecedor.setString(16,forn_ddi);
                        Insert_Fornecedor.setString(17,forn_ddd);
                        Insert_Fornecedor.setString(18,forn_tel);
                        Insert_Fornecedor.setString(19,forn_fax);
                        Insert_Fornecedor.setString(20,forn_cgc);
                        Insert_Fornecedor.setString(21,forn_inscrmunicial);
                        Insert_Fornecedor.setString(22,forn_cpf);
                        Insert_Fornecedor.setString(23,forn_ie);
                        Insert_Fornecedor.setString(24,forn_rg);
                        Insert_Fornecedor.setString(25,forn_email);
                        Insert_Fornecedor.setString(26,forn_rec_cofins);
                        Insert_Fornecedor.setString(27,forn_rec_csll);
                        Insert_Fornecedor.setString(28,forn_rec_pis);
                        Insert_Fornecedor.setString(29,forn_contribuinte);
                        Insert_Fornecedor.setTimestamp(30,getCurrentTimeStamp());// bpm_dt_criacao
                        Insert_Fornecedor.setString(31,bpm_id_cliente);
                        Insert_Fornecedor.setString(32,forn_tipo_cli);
                        Insert_Fornecedor.setString(33,forn_cod_efiscal);
                        Insert_Fornecedor.setString(34,forn_cod_municipio);
                        Insert_Fornecedor.setString(35,forn_nm_munic_corr);
                        Insert_Fornecedor.setString(36,forn_cgc_dig);
                        Insert_Fornecedor.setString(37,forn_pais);
                        Insert_Fornecedor.setString(38,forn_cod_pais);
                        
                        Insert_Fornecedor.executeUpdate();
                        
                        Insert_Fornecedor.close();
                        
                        }
                                             
                        Query = "INSERT INTO thor.header_nfe_thor( hnfe_cod_empresa, hnfe_nr_nf, hnfe_relaciona_itens, hnfe_serie, hnfe_cod_forn, hnfe_dt_emissao, hnfe_nf_estado, hnfe_tipo_nf, hnfe_valor_merc, hnfe_valor_bruto, hnfe_valor_icms, hnfe_base_icms, hnfe_valor_ipi, hnfe_base_ipi, hnfe_valor_desc, hnfe_valor_frete, hnfe_valor_seguro, hnfe_outras_despesas, hnfe_valor_icms_frete, hnfe_rec_iss, hnfe_nf_cancelada, bpm_dt_criacao, bpm_id_cliente, hnfe_dt_nf_canc, hnfe_valor_iss, hnfe_valor_bruto_ex, hnfe_nf_especie, hnfe_tem_1933, hnfe_base_subst_trib, hnfe_valor_subst_trib, hnfe_tem_1202, hnfe_cfop, hnfe_valor_pis, hnfe_valor_cofins, hnfe_valor_csll, hnfe_processado, hnfe_dt_entrada, hnfe_chave, hnfe_valor_isento_ipi, hnfe_valor_outras_ipi, hnfe_base_iss, hnfe_observacao, hnfe_ctrc, hnfe_xml, hnfe_cod_cli_filial, hnfe_nf_situacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                        PreparedStatement Insert_Header     = null;   
                       
                        Insert_Header = connection.prepareStatement(Query);
                              
                        Insert_Header.setString(1,hnfe_cod_empresa);
                        Insert_Header.setString(2,hnfe_nr_nf); 
                        Insert_Header.setString(3,hnfe_relaciona_itens); 
                        Insert_Header.setString(4,hnfe_serie); 
                        Insert_Header.setString(5,hnfe_cod_forn); 
                        Insert_Header.setString(6,hnfe_dt_emissao); 
                        Insert_Header.setString(7,hnfe_nf_estado);
                        Insert_Header.setString(8,hnfe_tipo_nf); 
                        Insert_Header.setString(9,hnfe_valor_merc); 
                        Insert_Header.setString(10,hnfe_valor_bruto); 
                        Insert_Header.setString(11,hnfe_valor_icms);
                        Insert_Header.setString(12,hnfe_base_icms); 
                        Insert_Header.setString(13,hnfe_valor_ipi); 
                        Insert_Header.setString(14,hnfe_base_ipi);
                        Insert_Header.setString(15,hnfe_valor_desc);
                        Insert_Header.setString(16,hnfe_valor_frete); 
                        Insert_Header.setString(17,hnfe_valor_seguro);
                        Insert_Header.setString(18,hnfe_outras_despesas); 
                        Insert_Header.setString(19,hnfe_valor_icms_frete);
                        Insert_Header.setString(20,hnfe_rec_iss);
                        Insert_Header.setString(21,hnfe_nf_cancelada);
                        Insert_Header.setTimestamp(22,getCurrentTimeStamp());// bpm_dt_criacao
                        Insert_Header.setString(23,bpm_id_cliente); 
                        Insert_Header.setString(24,hnfe_dt_nf_canc); 
                        Insert_Header.setString(25,hnfe_valor_iss);
                        Insert_Header.setString(26,hnfe_valor_bruto_ex); 
                        Insert_Header.setString(27,hnfe_nf_especie); 
                        Insert_Header.setNull(28, java.sql.Types.VARCHAR);// CAMPO hnfe_tem_1933
                        Insert_Header.setString(29,hnfe_base_subst_trib); 
                        Insert_Header.setString(30,hnfe_valor_subst_trib); 
                        Insert_Header.setString(31,hnfe_tem_1202);
                        Insert_Header.setString(32,hnfe_cfop); 
                        Insert_Header.setString(33,hnfe_valor_pis); 
                        Insert_Header.setString(34,hnfe_valor_cofins);
                        Insert_Header.setString(35,hnfe_valor_csll); 
                        Insert_Header.setNull(36, java.sql.Types.VARCHAR);//CAMPO hnfe_processado
                        Insert_Header.setString(37,hnfe_dt_entrada); 
                        Insert_Header.setString(38,hnfe_chave); 
                        Insert_Header.setString(39,hnfe_valor_isento_ipi); 
                        Insert_Header.setString(40,hnfe_valor_outras_ipi); 
                        Insert_Header.setString(41,hnfe_base_iss); 
                        Insert_Header.setString(42,hnfe_observacao); 
                        Insert_Header.setString(43,hnfe_ctrc);
                        Insert_Header.setString(44,hnfe_xml); 
                        Insert_Header.setString(45,hnfe_cod_cli_filial); 
                        Insert_Header.setString(46,hnfe_nf_situacao);
                        
                        Insert_Header.executeUpdate();
                        
                        Insert_Header.close();
                        
                        PreparedStatement Insert_Produto     = null;   
                        
                        for(int V = 0; V < P_PROD; V++){
                           PreparedStatement Select_Prod = null;
                           Query = "SELECT prod_cod FROM thor.cad_produtos WHERE prod_cod = ? AND prod_cod_empresa = ? ;";
                           Select_Prod = connection.prepareStatement(Query);
                           Select_Prod.setString(1,prod_cod.get(V));
                           Select_Prod.setString(2, prod_cod_empresa);
                           ResultSet R_Prod = Select_Prod.executeQuery();
                           
                            if (R_Prod.next()) {
                                     
                            }else{
                            
                            
                                Query = "INSERT INTO thor.cad_produtos(prod_cod_empresa, prod_cod, prod_descr, prod_complem, prod_tipo, prod_unid, prod_ncm, prod_nbm, prod_class_fiscal, prod_isbn, prod_aliq_icm, prod_aliq_ipi, prod_aliq_iss, prod_aliq_csll, prod_aliq_cofins, prod_aliq_pis, prod_aliq_icms_st, prod_trib_cfop_prod, bpm_dt_criacao, bpm_id_cliente, prod_quantidade, prod_valor_unitario, prod_valor_total, prod_cod_temp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                                Insert_Produto = connection.prepareStatement(Query);    
                                Insert_Produto.setString(1,prod_cod_empresa);
                                Insert_Produto.setString(2,prod_cod.get(V));
                                Insert_Produto.setString(3,prod_descr.get(V));
                                Insert_Produto.setString(4,prod_complem);
                                Insert_Produto.setString(5,prod_tipo); 
                                Insert_Produto.setString(6,prod_unid.get(V));
                                Insert_Produto.setString(7,prod_ncm.get(V)); 
                                Insert_Produto.setString(8,prod_nbm.get(V));
                                Insert_Produto.setString(9,prod_class_fiscal.get(V));
                                Insert_Produto.setString(10,prod_isbn.get(V));
                                Insert_Produto.setString(11,prod_aliq_icm.get(V));
                                Insert_Produto.setString(12,prod_aliq_ipi.get(V));
                                Insert_Produto.setString(13,prod_aliq_iss.get(V)); 
                                Insert_Produto.setString(14,prod_aliq_csll.get(V));
                                Insert_Produto.setString(15,prod_aliq_cofins.get(V));
                                Insert_Produto.setString(16,prod_aliq_pis.get(V)); 
                                Insert_Produto.setString(17,prod_aliq_icms_st.get(V)); 
                                Insert_Produto.setString(18,prod_trib_cfop_prod.get(V)); 
                                Insert_Produto.setTimestamp(19,getCurrentTimeStamp());// bpm_dt_criacao
                                Insert_Produto.setString(20,bpm_id_cliente);
                                Insert_Produto.setString(21,prod_quantidade.get(V));
                                Insert_Produto.setString(22,prod_valor_unitario.get(V)); 
                                Insert_Produto.setString(23,prod_valor_total.get(V));
                                Insert_Produto.setString(24,prod_cod_temp.get(V));

                                Insert_Produto.executeUpdate();
                                Insert_Produto.close();
                        
                            }
                            R_Prod.close();
                        }

                        PreparedStatement Insert_Detail = null;   
                       
                        for(int N = 0; N < P_PROD; N++){
                        
                        Query = "INSERT INTO thor.detail_nfe_thor(dnfe_cod_empresa, dnfe_nr_nf, dnfe_relaciona_itens, dnfe_serie, dnfe_cod_forn, dnfe_dt_emissao, dnfe_tipo, dnfe_class_fiscal, dnfe_cod_trib, dnfe_cfop, dnfe_nr_item, dnfe_cod_prod, dnfe_cod_descr, dnfe_unid_prod, dnfe_quantidade, dnfe_valor_unit, dnfe_valor_total, dnfe_valor_ipi, dnfe_valor_icm, dnfe_valor_desc, dnfe_aliq_ipi, dnfe_aliq_icm, dnfe_aliq_iss, dnfe_base_icm, dnfe_base_ipi, dnfe_base_iss, dnfe_valor_iss, dnfe_base_irr, dnfe_aliq_irr, dnfe_valor_irr, dnfe_trib_cfop_prod, dnfe_forma_trib_nfe, dnfe_nf_cancelada, bpm_dt_criacao, bpm_id_cliente, dnfe_base_subst_trib, dnfe_valor_subst_trib, hnfe_valor_bruto, hnfe_valor_merc, dnfe_valor_trib_icms, dnfe_valor_isento_icms, dnfe_valor_outras_icms, dnfe_valor_trib_ipi, dnfe_valor_isento_ipi, dnfe_valor_outras_ipi, dnfe_nf_especie, dnfe_base_pis, dnfe_base_cofins, dnfe_valor_pis, dnfe_valor_cofins, dnfe_codtrib_pis, dnfe_codtrib_cofins, dnfe_flag_control, dnfe_ctipi, dnfe_processado, dnfe_dt_entrada, dnfe_id_produto, dnfe_piscofins, dnfe_valor_frete, dnfe_outras_despesas, dnfe_ctrc, dnfe_prod_temp, dnfe_cod_cli_filial, dnfe_nf_situacao, dnfe_peso, dnfe_observacao, dnfe_ct, dnfe_situacao_piscofins,dnfe_vlr_bas_fcp_retido_st,dnfe_porcentual_fcp_retido_st,dnfe_vlr_fcp_retido_st,dnfe_cod_cest ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                        Insert_Detail = connection.prepareStatement(Query);
                        Insert_Detail.setString(1,dnfe_cod_empresa);                     
                        Insert_Detail.setString(2,dnfe_nr_nf); 
                        Insert_Detail.setString(3,dnfe_relaciona_itens); 
                        Insert_Detail.setString(4,dnfe_serie); 
                        Insert_Detail.setString(5,dnfe_cod_forn); 
                        Insert_Detail.setString(6,dnfe_dt_emissao); 
                        Insert_Detail.setString(7,dnfe_tipo); 
                        Insert_Detail.setString(8,dnfe_class_fiscal.get(N));
                        Insert_Detail.setString(9,dnfe_cod_trib.get(N)); 
                        Insert_Detail.setString(10,dnfe_cfop.get(N)); 
                        Insert_Detail.setString(11,dnfe_nr_item.get(N).toString());
                        Insert_Detail.setString(12,dnfe_cod_prod.get(N));
                        Insert_Detail.setString(13,dnfe_cod_descr.get(N));
                        Insert_Detail.setString(14,dnfe_unid_prod.get(N));
                        Insert_Detail.setString(15,dnfe_quantidade.get(N));
                        Insert_Detail.setString(16,dnfe_valor_unit.get(N));
                        Insert_Detail.setString(17,dnfe_valor_total.get(N));
                        Insert_Detail.setString(18,dnfe_valor_ipi.get(N));
                        Insert_Detail.setString(19,dnfe_valor_icm.get(N));
                        Insert_Detail.setString(20,dnfe_valor_desc.get(N));
                        Insert_Detail.setString(21,dnfe_aliq_ipi.get(N));
                        Insert_Detail.setString(22,dnfe_aliq_icm.get(N));
                        Insert_Detail.setString(23,dnfe_aliq_iss.get(N));
                        Insert_Detail.setString(24,dnfe_base_icm.get(N));
                        Insert_Detail.setString(25,dnfe_base_ipi.get(N));
                        Insert_Detail.setString(26,dnfe_base_iss.get(N));
                        Insert_Detail.setString(27,dnfe_valor_iss.get(N)); 
                        Insert_Detail.setString(28,dnfe_base_irr.get(N));
                        Insert_Detail.setString(29,dnfe_aliq_irr.get(N));
                        Insert_Detail.setString(30,dnfe_valor_irr.get(N));
                        Insert_Detail.setString(31,dnfe_trib_cfop_prod.get(N));
                        Insert_Detail.setString(32,dnfe_forma_trib_nfe.get(N));
                        Insert_Detail.setString(33,dnfe_nf_cancelada); 
                        Insert_Detail.setTimestamp(34,getCurrentTimeStamp());// bpm_dt_criacao
                        Insert_Detail.setString(35,bpm_id_cliente); 
                        Insert_Detail.setString(36,dnfe_base_subst_trib.get(N));
                        Insert_Detail.setString(37,dnfe_valor_subst_trib.get(N));
                        Insert_Detail.setString(38,hnfe_valor_bruto); 
                        Insert_Detail.setString(39,hnfe_valor_merc); 
                        Insert_Detail.setString(40,dnfe_valor_trib_icms.get(N));
                        Insert_Detail.setString(41,dnfe_valor_isento_icms.get(N));
                        Insert_Detail.setString(42,dnfe_valor_outras_icms.get(N));
                        Insert_Detail.setString(43,dnfe_valor_trib_ipi.get(N));
                        Insert_Detail.setString(44,dnfe_valor_isento_ipi.get(N));
                        Insert_Detail.setString(45,dnfe_valor_outras_ipi.get(N));
                        Insert_Detail.setString(46,dnfe_nf_especie); 
                        Insert_Detail.setString(47,dnfe_base_pis.get(N));
                        Insert_Detail.setString(48,dnfe_base_cofins.get(N));
                        Insert_Detail.setString(49,dnfe_valor_pis.get(N));
                        Insert_Detail.setString(50,dnfe_valor_cofins.get(N));
                        Insert_Detail.setString(51,dnfe_codtrib_pis.get(N));
                        Insert_Detail.setString(52,dnfe_codtrib_cofins.get(N));
                        Insert_Detail.setString(53,dnfe_flag_control); 
                        Insert_Detail.setString(54,dnfe_ctipi.get(N));
                        Insert_Detail.setNull(55,java.sql.Types.VARCHAR); //CAMPO dnfe_processado
                        Insert_Detail.setString(56,dnfe_dt_entrada); 
                        Insert_Detail.setString(57,dnfe_id_produto.get(N));
                        Insert_Detail.setString(58,dnfe_piscofins.get(N));
                        Insert_Detail.setString(59,dnfe_valor_frete.get(N));
                        Insert_Detail.setString(60,dnfe_outras_despesas.get(N));
                        Insert_Detail.setString(61,dnfe_ctrc.get(N));
                        Insert_Detail.setString(62,dnfe_prod_temp.get(N));
                        Insert_Detail.setNull(63,java.sql.Types.VARCHAR);//CAMPO dnfe_cod_cli_filial
                        Insert_Detail.setString(64,dnfe_nf_situacao.get(N));
                        Insert_Detail.setNull(65,java.sql.Types.VARCHAR); //CAMPO dnfe_peso
                        Insert_Detail.setString(66,dnfe_observacao.get(N));
                        Insert_Detail.setString(67,dnfe_ct.get(N));
                        Insert_Detail.setString(68,dnfe_situacao_piscofins.get(N));
                        Insert_Detail.setString(69,dnfe_vlr_bas_fcp_retido_st.get(N));
			Insert_Detail.setString(70,dnfe_porcentual_fcp_retido_st.get(N));
			Insert_Detail.setString(71,dnfe_vlr_fcp_retido_st.get(N));
			Insert_Detail.setString(72,dnfe_cod_cest.get(N));
                        Insert_Detail.executeUpdate();
                        Insert_Detail.close();
                        }
                                                  
                            
                            ////System.out.println(Query);
                            File log_file_base = new File(diretorio+"\\Log.txt");
                            FileOutputStream log_base = new FileOutputStream(log_file_base,true);
 
                            BufferedWriter bwbase = new BufferedWriter(new OutputStreamWriter(log_base));
                            //bwbase.write("codigo municipal            : " + forn_cod_municipio + " Posicao: " + + xml_pos);
                            bwbase.write("CHAVE INTEGRADA             : " + hnfe_chave + " Posicao: " + xml_pos);
                            bwbase.newLine();
                            bwbase.close();
                            
                        }
                        
                        // connection.prepareStatement(Query);
                        // stmt.executeU(Query); 
                        //connection.commit(); 
                        //stmt.execute(Query);
                        //connection.commit();
                                          
                        connection.close();
                        
                    } else {
                        ////System.out.println("Failed to make connection!");
                        ////System.out.println(Query);
                            File log_file_base = new File(diretorio+"\\Log.txt");
                            FileOutputStream log_base = new FileOutputStream(log_file_base,true);
 
                            BufferedWriter bwbase = new BufferedWriter(new OutputStreamWriter(log_base));
                            //bwbase.write("codigo municipal            : " + forn_cod_municipio + " Posicao: " + + xml_pos);
                            bwbase.write("CHAVE NAO INTEGRADA         : " + hnfe_chave + " Posicao: " + xml_pos);
                            bwbase.newLine();
                            bwbase.close();
                            connection.close();
                    }
                } catch (SQLException e) {

			// ////System.out.println("nota inserida!!!");
			e.printStackTrace();
                       
                            File log_file_base = new File(diretorio+"\\log_conexao.txt");
                            FileOutputStream log_base = new FileOutputStream(log_file_base,true);
 
                            BufferedWriter bwbase = new BufferedWriter(new OutputStreamWriter(log_base));
                            bwbase.write(e.getMessage());
                            bwbase.newLine();
                            
                            bwbase.close();
                            connection.close();
                            
               try {
              
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("erroConexao.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Image image = new Image("/loki/source/loki.png");
                    Stage stage = new Stage();
                    stage.setTitle("Loki 3.00");
                    stage.getIcons().add(image);
                    stage.setScene(new Scene(root1));  
                    stage.show();
                } catch(Exception ex) {
                    e.printStackTrace();
                }
                    return;
		}
            }else{// 
             
            }
                //chaves_bar +=  (double) 100.0/(double) diretorio.listFiles().length  ; 
               // progresso.setProgress(chaves_bar);
           }
            //System.out.println(erro);
            
            try {
              
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FIM.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    FIMController Fim = new FIMController();
                    Fim = fxmlLoader.getController();
                    Fim.set_l_dir(log_d);
                    Image image = new Image("/loki/source/loki.png");
                    Stage stage = new Stage();
                    stage.setTitle("Loki 3.00");
                    stage.getIcons().add(image);
                    stage.setScene(new Scene(root1));  
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            
                            File log_file_final = new File(diretorio+"\\Log.txt");
                            FileOutputStream log_final = new FileOutputStream(log_file_final,true);
 
                            BufferedWriter bwbase = new BufferedWriter(new OutputStreamWriter(log_final));
                       
                            bwbase.newLine();
                            bwbase.write("TOTAL DE CHAVE INTEGRADAS: " + (qtchaves));
                            bwbase.newLine();
                            bwbase.write("FINALIZADO EM : " + getCurrentTimeStamp());
                            bwbase.newLine();
                            bwbase.close();
                            connection.close();
                            qtchaves = 0;
                            
     //processos_id.setText("Chaves Processadas!!!!");        
     }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      progresso.setProgress(100.0);
   
     //txt.setOnMouseExited(e -> teste_01());
      
       diretorio_id.setOnMouseExited(e -> liberar_processo());
       //txt.setOnMouseEntered(e ->teste_01()
       diretorio_id.setOnMouseEntered(e -> liberar_processo());
       ano_id.setOnMouseExited(e -> validar_data());
       mes_id.setOnMouseExited(e -> validar_data());
       btn_novo_p.setOnAction(e -> reload());
       ancora.setOnMouseExited(e -> liberar_processo());
       ancora.setOnMouseEntered(e -> liberar_processo());
    
    }    
    
}
