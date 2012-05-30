

/* First created by JCasGen Tue May 15 20:27:33 CEST 2012 */
package com.seemla.rssf;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed May 30 19:44:33 CEST 2012
 * XML source: /home/cdepablo/git/rssf-ie/rssf-ie/desc/RSSFTypeSystem.xml
 * @generated */
public class Competition extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Competition.class);
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
  protected Competition() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Competition(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Competition(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Competition(JCas jcas, int begin, int end) {
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
  //* Feature: name

  /** getter for name - gets 
   * @generated */
  public String getName() {
    if (Competition_Type.featOkTst && ((Competition_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.seemla.rssf.Competition");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Competition_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (Competition_Type.featOkTst && ((Competition_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.seemla.rssf.Competition");
    jcasType.ll_cas.ll_setStringValue(addr, ((Competition_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: season

  /** getter for season - gets 
   * @generated */
  public String getSeason() {
    if (Competition_Type.featOkTst && ((Competition_Type)jcasType).casFeat_season == null)
      jcasType.jcas.throwFeatMissing("season", "com.seemla.rssf.Competition");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Competition_Type)jcasType).casFeatCode_season);}
    
  /** setter for season - sets  
   * @generated */
  public void setSeason(String v) {
    if (Competition_Type.featOkTst && ((Competition_Type)jcasType).casFeat_season == null)
      jcasType.jcas.throwFeatMissing("season", "com.seemla.rssf.Competition");
    jcasType.ll_cas.ll_setStringValue(addr, ((Competition_Type)jcasType).casFeatCode_season, v);}    
   
    
  //*--------------*
  //* Feature: start

  /** getter for start - gets 
   * @generated */
  public int getStart() {
    if (Competition_Type.featOkTst && ((Competition_Type)jcasType).casFeat_start == null)
      jcasType.jcas.throwFeatMissing("start", "com.seemla.rssf.Competition");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Competition_Type)jcasType).casFeatCode_start);}
    
  /** setter for start - sets  
   * @generated */
  public void setStart(int v) {
    if (Competition_Type.featOkTst && ((Competition_Type)jcasType).casFeat_start == null)
      jcasType.jcas.throwFeatMissing("start", "com.seemla.rssf.Competition");
    jcasType.ll_cas.ll_setIntValue(addr, ((Competition_Type)jcasType).casFeatCode_start, v);}    
  }

    