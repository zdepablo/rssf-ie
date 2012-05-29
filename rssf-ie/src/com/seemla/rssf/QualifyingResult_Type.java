
/* First created by JCasGen Thu May 17 12:22:54 CEST 2012 */
package com.seemla.rssf;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue May 29 13:46:08 CEST 2012
 * @generated */
public class QualifyingResult_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (QualifyingResult_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = QualifyingResult_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new QualifyingResult(addr, QualifyingResult_Type.this);
  			   QualifyingResult_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new QualifyingResult(addr, QualifyingResult_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = QualifyingResult.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.seemla.rssf.QualifyingResult");
 
  /** @generated */
  final Feature casFeat_result;
  /** @generated */
  final int     casFeatCode_result;
  /** @generated */ 
  public int getResult(int addr) {
        if (featOkTst && casFeat_result == null)
      jcas.throwFeatMissing("result", "com.seemla.rssf.QualifyingResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_result);
  }
  /** @generated */    
  public void setResult(int addr, int v) {
        if (featOkTst && casFeat_result == null)
      jcas.throwFeatMissing("result", "com.seemla.rssf.QualifyingResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_result, v);}
    
  
 
  /** @generated */
  final Feature casFeat_competition;
  /** @generated */
  final int     casFeatCode_competition;
  /** @generated */ 
  public int getCompetition(int addr) {
        if (featOkTst && casFeat_competition == null)
      jcas.throwFeatMissing("competition", "com.seemla.rssf.QualifyingResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_competition);
  }
  /** @generated */    
  public void setCompetition(int addr, int v) {
        if (featOkTst && casFeat_competition == null)
      jcas.throwFeatMissing("competition", "com.seemla.rssf.QualifyingResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_competition, v);}
    
  
 
  /** @generated */
  final Feature casFeat_phase;
  /** @generated */
  final int     casFeatCode_phase;
  /** @generated */ 
  public int getPhase(int addr) {
        if (featOkTst && casFeat_phase == null)
      jcas.throwFeatMissing("phase", "com.seemla.rssf.QualifyingResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_phase);
  }
  /** @generated */    
  public void setPhase(int addr, int v) {
        if (featOkTst && casFeat_phase == null)
      jcas.throwFeatMissing("phase", "com.seemla.rssf.QualifyingResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_phase, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public QualifyingResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_result = jcas.getRequiredFeatureDE(casType, "result", "com.seemla.rssf.MatchPairResult", featOkTst);
    casFeatCode_result  = (null == casFeat_result) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_result).getCode();

 
    casFeat_competition = jcas.getRequiredFeatureDE(casType, "competition", "com.seemla.rssf.Competition", featOkTst);
    casFeatCode_competition  = (null == casFeat_competition) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_competition).getCode();

 
    casFeat_phase = jcas.getRequiredFeatureDE(casType, "phase", "com.seemla.rssf.Phase", featOkTst);
    casFeatCode_phase  = (null == casFeat_phase) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_phase).getCode();

  }
}



    