

/* First created by JCasGen Mon May 14 21:00:44 CEST 2012 */
package com.seemla.rssf;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue May 15 20:27:33 CEST 2012
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
  //* Feature: result

  /** getter for result - gets 
   * @generated */
  public String getResult() {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_result == null)
      jcasType.jcas.throwFeatMissing("result", "com.seemla.rssf.MatchResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MatchResult_Type)jcasType).casFeatCode_result);}
    
  /** setter for result - sets  
   * @generated */
  public void setResult(String v) {
    if (MatchResult_Type.featOkTst && ((MatchResult_Type)jcasType).casFeat_result == null)
      jcasType.jcas.throwFeatMissing("result", "com.seemla.rssf.MatchResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((MatchResult_Type)jcasType).casFeatCode_result, v);}    
  }

    