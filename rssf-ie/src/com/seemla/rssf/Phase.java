

/* First created by JCasGen Tue May 15 19:40:51 CEST 2012 */
package com.seemla.rssf;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue May 29 13:26:57 CEST 2012
 * XML source: /home/cdepablo/git/rssf-ie/rssf-ie/desc/RSSFTypeSystem.xml
 * @generated */
public class Phase extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Phase.class);
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
  protected Phase() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Phase(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Phase(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Phase(JCas jcas, int begin, int end) {
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
    if (Phase_Type.featOkTst && ((Phase_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.seemla.rssf.Phase");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Phase_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (Phase_Type.featOkTst && ((Phase_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.seemla.rssf.Phase");
    jcasType.ll_cas.ll_setStringValue(addr, ((Phase_Type)jcasType).casFeatCode_name, v);}    
  }

    