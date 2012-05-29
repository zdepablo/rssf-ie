

/* First created by JCasGen Tue May 29 13:46:08 CEST 2012 */
package com.seemla.rssf;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue May 29 13:46:08 CEST 2012
 * XML source: /home/cdepablo/git/rssf-ie/rssf-ie/desc/RSSFTypeSystem.xml
 * @generated */
public class MatchResult extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(MatchResult.class);
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
  protected MatchResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public MatchResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public MatchResult(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public MatchResult(JCas jcas, int begin, int end) {
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
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_team1 == null)
      jcasType.jcas.throwFeatMissing("team1", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MatchResult_Type)jcasType).casFeatCode_team1);}
    
  /** setter for team1 - sets  
   * @generated */
  public void setTeam1(String v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_team1 == null)
      jcasType.jcas.throwFeatMissing("team1", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((MatchResult_Type)jcasType).casFeatCode_team1, v);}    
   
    
  //*--------------*
  //* Feature: team2

  /** getter for team2 - gets 
   * @generated */
  public String getTeam2() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_team2 == null)
      jcasType.jcas.throwFeatMissing("team2", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MatchResult_Type)jcasType).casFeatCode_team2);}
    
  /** setter for team2 - sets  
   * @generated */
  public void setTeam2(String v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_team2 == null)
      jcasType.jcas.throwFeatMissing("team2", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((MatchResult_Type)jcasType).casFeatCode_team2, v);}    
   
    
  //*--------------*
  //* Feature: result1

  /** getter for result1 - gets 
   * @generated */
  public int getResult1() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_result1 == null)
      jcasType.jcas.throwFeatMissing("result1", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_result1);}
    
  /** setter for result1 - sets  
   * @generated */
  public void setResult1(int v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_result1 == null)
      jcasType.jcas.throwFeatMissing("result1", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_result1, v);}    
   
    
  //*--------------*
  //* Feature: result2

  /** getter for result2 - gets 
   * @generated */
  public int getResult2() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_result2 == null)
      jcasType.jcas.throwFeatMissing("result2", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_result2);}
    
  /** setter for result2 - sets  
   * @generated */
  public void setResult2(int v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_result2 == null)
      jcasType.jcas.throwFeatMissing("result2", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_result2, v);}    
   
    
  //*--------------*
  //* Feature: mid1

  /** getter for mid1 - gets 
   * @generated */
  public int getMid1() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_mid1 == null)
      jcasType.jcas.throwFeatMissing("mid1", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_mid1);}
    
  /** setter for mid1 - sets  
   * @generated */
  public void setMid1(int v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_mid1 == null)
      jcasType.jcas.throwFeatMissing("mid1", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_mid1, v);}    
   
    
  //*--------------*
  //* Feature: mid2

  /** getter for mid2 - gets 
   * @generated */
  public int getMid2() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_mid2 == null)
      jcasType.jcas.throwFeatMissing("mid2", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_mid2);}
    
  /** setter for mid2 - sets  
   * @generated */
  public void setMid2(int v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_mid2 == null)
      jcasType.jcas.throwFeatMissing("mid2", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_mid2, v);}    
  }

    