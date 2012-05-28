

/* First created by JCasGen Thu May 17 12:22:54 CEST 2012 */
package com.seemla.rssf;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon May 28 19:36:37 CEST 2012
 * XML source: /home/cdepablo/git/rssf-ie/rssf-ie/desc/RSSFTypeSystem.xml
 * @generated */
public class QualifyingResult extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(QualifyingResult.class);
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
  protected QualifyingResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public QualifyingResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public QualifyingResult(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public QualifyingResult(JCas jcas, int begin, int end) {
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
  public MatchResult getResult() {
    if (QualifyingResult_Type.featOkTst && ((QualifyingResult_Type)jcasType).casFeat_result == null)
      jcasType.jcas.throwFeatMissing("result", "com.seemla.rssf.QualifyingResult");
    return (MatchResult)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QualifyingResult_Type)jcasType).casFeatCode_result)));}
    
  /** setter for result - sets  
   * @generated */
  public void setResult(MatchResult v) {
    if (QualifyingResult_Type.featOkTst && ((QualifyingResult_Type)jcasType).casFeat_result == null)
      jcasType.jcas.throwFeatMissing("result", "com.seemla.rssf.QualifyingResult");
    jcasType.ll_cas.ll_setRefValue(addr, ((QualifyingResult_Type)jcasType).casFeatCode_result, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: competition

  /** getter for competition - gets 
   * @generated */
  public Competition getCompetition() {
    if (QualifyingResult_Type.featOkTst && ((QualifyingResult_Type)jcasType).casFeat_competition == null)
      jcasType.jcas.throwFeatMissing("competition", "com.seemla.rssf.QualifyingResult");
    return (Competition)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QualifyingResult_Type)jcasType).casFeatCode_competition)));}
    
  /** setter for competition - sets  
   * @generated */
  public void setCompetition(Competition v) {
    if (QualifyingResult_Type.featOkTst && ((QualifyingResult_Type)jcasType).casFeat_competition == null)
      jcasType.jcas.throwFeatMissing("competition", "com.seemla.rssf.QualifyingResult");
    jcasType.ll_cas.ll_setRefValue(addr, ((QualifyingResult_Type)jcasType).casFeatCode_competition, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: phase

  /** getter for phase - gets 
   * @generated */
  public Phase getPhase() {
    if (QualifyingResult_Type.featOkTst && ((QualifyingResult_Type)jcasType).casFeat_phase == null)
      jcasType.jcas.throwFeatMissing("phase", "com.seemla.rssf.QualifyingResult");
    return (Phase)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QualifyingResult_Type)jcasType).casFeatCode_phase)));}
    
  /** setter for phase - sets  
   * @generated */
  public void setPhase(Phase v) {
    if (QualifyingResult_Type.featOkTst && ((QualifyingResult_Type)jcasType).casFeat_phase == null)
      jcasType.jcas.throwFeatMissing("phase", "com.seemla.rssf.QualifyingResult");
    jcasType.ll_cas.ll_setRefValue(addr, ((QualifyingResult_Type)jcasType).casFeatCode_phase, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    