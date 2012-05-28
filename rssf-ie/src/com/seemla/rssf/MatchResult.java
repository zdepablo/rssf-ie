

/* First created by JCasGen Mon May 14 21:00:44 CEST 2012 */
package com.seemla.rssf;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon May 28 19:36:37 CEST 2012
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
  //* Feature: country1

  /** getter for country1 - gets 
   * @generated */
  public String getCountry1() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_country1 == null)
      jcasType.jcas.throwFeatMissing("country1", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MatchResult_Type)jcasType).casFeatCode_country1);}
    
  /** setter for country1 - sets  
   * @generated */
  public void setCountry1(String v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_country1 == null)
      jcasType.jcas.throwFeatMissing("country1", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((MatchResult_Type)jcasType).casFeatCode_country1, v);}    
   
    
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
  //* Feature: country2

  /** getter for country2 - gets 
   * @generated */
  public String getCountry2() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_country2 == null)
      jcasType.jcas.throwFeatMissing("country2", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MatchResult_Type)jcasType).casFeatCode_country2);}
    
  /** setter for country2 - sets  
   * @generated */
  public void setCountry2(String v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_country2 == null)
      jcasType.jcas.throwFeatMissing("country2", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((MatchResult_Type)jcasType).casFeatCode_country2, v);}    
   
    
  //*--------------*
  //* Feature: leg1_1

  /** getter for leg1_1 - gets 
   * @generated */
  public int getLeg1_1() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_leg1_1 == null)
      jcasType.jcas.throwFeatMissing("leg1_1", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_leg1_1);}
    
  /** setter for leg1_1 - sets  
   * @generated */
  public void setLeg1_1(int v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_leg1_1 == null)
      jcasType.jcas.throwFeatMissing("leg1_1", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_leg1_1, v);}    
   
    
  //*--------------*
  //* Feature: leg1_2

  /** getter for leg1_2 - gets 
   * @generated */
  public int getLeg1_2() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_leg1_2 == null)
      jcasType.jcas.throwFeatMissing("leg1_2", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_leg1_2);}
    
  /** setter for leg1_2 - sets  
   * @generated */
  public void setLeg1_2(int v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_leg1_2 == null)
      jcasType.jcas.throwFeatMissing("leg1_2", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_leg1_2, v);}    
   
    
  //*--------------*
  //* Feature: leg2_1

  /** getter for leg2_1 - gets 
   * @generated */
  public int getLeg2_1() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_leg2_1 == null)
      jcasType.jcas.throwFeatMissing("leg2_1", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_leg2_1);}
    
  /** setter for leg2_1 - sets  
   * @generated */
  public void setLeg2_1(int v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_leg2_1 == null)
      jcasType.jcas.throwFeatMissing("leg2_1", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_leg2_1, v);}    
   
    
  //*--------------*
  //* Feature: leg2_2

  /** getter for leg2_2 - gets 
   * @generated */
  public int getLeg2_2() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_leg2_2 == null)
      jcasType.jcas.throwFeatMissing("leg2_2", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_leg2_2);}
    
  /** setter for leg2_2 - sets  
   * @generated */
  public void setLeg2_2(int v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_leg2_2 == null)
      jcasType.jcas.throwFeatMissing("leg2_2", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_leg2_2, v);}    
   
    
  //*--------------*
  //* Feature: total_1

  /** getter for total_1 - gets 
   * @generated */
  public int getTotal_1() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_total_1 == null)
      jcasType.jcas.throwFeatMissing("total_1", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_total_1);}
    
  /** setter for total_1 - sets  
   * @generated */
  public void setTotal_1(int v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_total_1 == null)
      jcasType.jcas.throwFeatMissing("total_1", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_total_1, v);}    
   
    
  //*--------------*
  //* Feature: total_2

  /** getter for total_2 - gets 
   * @generated */
  public int getTotal_2() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_total_2 == null)
      jcasType.jcas.throwFeatMissing("total_2", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_total_2);}
    
  /** setter for total_2 - sets  
   * @generated */
  public void setTotal_2(int v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_total_2 == null)
      jcasType.jcas.throwFeatMissing("total_2", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((MatchResult_Type)jcasType).casFeatCode_total_2, v);}    
  }

    