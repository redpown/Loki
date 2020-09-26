/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loki.components;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Jarvis
 */
public class Components {
    
    public String formater(String xml){
    String Texto = xml;
    Texto = Texto.toUpperCase();
    Texto = Texto.replaceAll("Ç","C");
    Texto = Texto.replaceAll("Â","A");
    Texto = Texto.replaceAll("Á","A");
    Texto = Texto.replaceAll("Ê","E");
    Texto = Texto.replaceAll("&","E");
    Texto = Texto.replaceAll("É","E");
    Texto = Texto.replaceAll("Í","I");
    Texto = Texto.replaceAll("Ó","O");
    Texto = Texto.replaceAll("Ú","U");
    Texto = Texto.replaceAll("Ã","A");
    Texto = Texto.replaceAll("Õ","O");
    Texto = Texto.replaceAll("M²","M");
    Texto = Texto.replaceAll("."," ");
    Texto = Texto.replaceAll("[\\.\\#\\@\\$\\%\\*\\!\\'\\\"\\,\\+\\-\\?\\ª\\º]", "");
    xml = Texto ;
    
        return xml;
    }
   
    /*
    public void Logger(File dir,int erro, Exception e,String nf,String Chave, int pos,int qt,String cnpj) throws FileNotFoundException, IOException{
        
    
    

    ///////////////////////////////////////////////////////////////////////    
      
                            Node nChaveE = doc.getElementsByTagName(doc.getDocumentElement().getNodeName()).item(0).getChildNodes().item(0).getChildNodes().item(0);
                            Element eChaveE = (Element) nChaveE;
                            File log_chave_load = new File(dir+"\\CHAVE.txt");
                            FileOutputStream log_nf_chave = new FileOutputStream(log_chave_load,true);
 
                            BufferedWriter tipo_nota = new BufferedWriter(new OutputStreamWriter(log_nf_chave));
                            tipo_nota.write("Tipo de nota : " + nf+" CHAVE: " + Chave+" Posicao: " + pos);
                            tipo_nota.newLine();
                            tipo_nota.close();
    ///////////////////////////////////////////////////////////////////////    
      
                            Node nChaveE = doc.getElementsByTagName(doc.getDocumentElement().getNodeName()).item(0).getChildNodes().item(0).getChildNodes().item(0);
                            Element eChaveE = (Element) nChaveE;
                            File log_chave_load = new File(dir+"\\CHAVE.txt");
                            FileOutputStream log_nf_chave = new FileOutputStream(log_chave_load,true);
 
                            BufferedWriter tipo_nota = new BufferedWriter(new OutputStreamWriter(log_nf_chave));
                            tipo_nota.write("Tipo de nota : " + nf+" CHAVE: " + Chave+" Posicao: " + pos);
                            tipo_nota.newLine();
                            tipo_nota.close();
    ///////////////////////////////////////////////////////////////////////    
      
                            Node nChaveE = doc.getElementsByTagName(doc.getDocumentElement().getNodeName()).item(0).getChildNodes().item(0).getChildNodes().item(0);
                            Element eChaveE = (Element) nChaveE;
                            File log_chave_load = new File(dir+"\\CHAVE.txt");
                            FileOutputStream log_nf_chave = new FileOutputStream(log_chave_load,true);
 
                            BufferedWriter tipo_nota = new BufferedWriter(new OutputStreamWriter(log_nf_chave));
                            tipo_nota.write("Tipo de nota : " + nf+" CHAVE: " + Chave+" Posicao: " + pos);
                            tipo_nota.newLine();
                            tipo_nota.close();
    ////////////////////////////////////////////////////////////////
                            File log_erro_xml = new File(dir+"\\ERRO_LEITURA.txt");
                            FileOutputStream log_file_erro_xml = new FileOutputStream(log_erro_xml,true);
 
                            BufferedWriter bwerro_xml = new BufferedWriter(new OutputStreamWriter(log_file_erro_xml));
                            bwerro_xml.write("Erro de Leitura: " + e.getMessage()+" CHAVE: "+ Chave+ " Posicao:" + pos);
                            bwerro_xml.newLine();
                            bwerro_xml.close();
                           
     /////////////////////////////////////////////////////////
     if(){
                            File log_file = new File(dir+"\\Log.txt");
                            FileOutputStream log = new FileOutputStream(log_file,true);
 
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(log));
                            bw.write("CNPJ NÃO CADASTRADO :" + cnpj + " CHAVE: "+ Chave +" Posicao: " +  pos);
                            bw.newLine();
                            bw.close();
     }else if(){
                            
                            ////System.out.println("\nNota ja inserida na base!");
                            File log_file_nota = new File(dir+"\\Log.txt");
                            FileOutputStream log_nf = new FileOutputStream(log_file_nota,true);
 
                            BufferedWriter bwn = new BufferedWriter(new OutputStreamWriter(log_nf));
                            //bwn.write("codigo municipal            : " + forn_cod_municipio + " Posicao: " + + xml_pos);
                            bwn.write("CHAVE JA INTEGRADA          :" + Chave+" Posicao: " +  pos);
                            bwn.newLine();
                            bwn.close();
     }else if(){
                            
                            
                            // ////System.out.println(Query);
                            File log_file_base = new File(dir+"\\Log.txt");
                            FileOutputStream log_base = new FileOutputStream(log_file_base,true);
 
                            BufferedWriter bwbase = new BufferedWriter(new OutputStreamWriter(log_base));
                          //  bwbase.write("codigo municipal            : " + forn_cod_municipio + " Posicao: " + + xml_pos);
                            bwbase.write("CHAVE INTEGRADA             : " + Chave + " Posicao: " + pos);
                            bwbase.newLine();
                            bwbase.close();
     }else{            
     ///////////////////////////////////////////////////////////////////////////////////////////////////                       
                            File log_file_final = new File(dir+"\\Log.txt");
                            FileOutputStream log_final = new FileOutputStream(log_file_final,true);
 
                            BufferedWriter bwbase = new BufferedWriter(new OutputStreamWriter(log_final));
                       
                            bwbase.newLine();
                            bwbase.write("TOTAL DE CHAVE INTEGRADAS: " + (qt - 1));
                            bwbase.newLine();
                            bwbase.write("FINALIZADO EM : " + getCurrentTimeStamp());
                            bwbase.newLine();
                            bwbase.close();
     }
    }
*/
            
    
}
