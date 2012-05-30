

/* First created by JCasGen Wed May 30 19:40:54 CEST 2012 */
package com.seemla.rssf;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed May 30 19:44:33 CEST 2012
 * XML source: /home/cdepablo/git/rssf-ie/rssf-ie/desc/RSSFTypeSystem.xml
 * @generated */
public class Result extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Result.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Result() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Result(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Result(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Result(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: team1

  /** getter for team1 - gets 
   * @generated */
  public String getTeam1() {
    if (Result_Type.featOkTst && ((Result_Type)jcasType).casFeat_team1 == null)
      jcasType.jcas.throwFeatMissing("team1", "com.seemla.rssf.Result");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Result_Type)jcasType).casFeatCode_team1);}
    
  /** setter for team1 - sets  
   * @generated */
  public void setTeam1(String v) {
    if (Result_Type.featOkTst && ((Result_Type)jcasType).casFeat_team1 == null)
      jcasType.jcas.throwFeatMissing("team1", "com.seemla.rssf.Result");
    jcasType.ll_cas.ll_setStringValue(addr, ((Result_Type)jcasType).casFeatCode_team1, v);}    
   
    
  //*--------------*
  //* Feature: team2

  /** getter for team2 - gets 
   * @generated */
  public String getTeam2() {
    if (Result_Type.featOkTst && ((Result_Type)jcasType).casFeat_team2 == null)
      jcasType.jcas.throwFeatMissing("team2", "com.seemla.rssf.Result");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Result_Type)jcasType).casFeatCode_team2);}
    
  /** setter for team2 - sets  
   * @generated */
  public void setTeam2(String v) {
    if (Result_Type.featOkTst && ((Result_Type)jcasType).casFeat_team2 == null)
      jcasType.jcas.throwFeatMissing("team2", "com.seemla.rssf.Result");
    jcasType.ll_cas.ll_setStringValue(addr, ((Result_Type)jcasType).casFeatCode_team2, v);}    
  }

    