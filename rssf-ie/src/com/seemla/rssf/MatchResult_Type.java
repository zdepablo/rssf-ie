
/* First created by JCasGen Tue May 29 13:46:08 CEST 2012 */
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
 * Updated by JCasGen Wed May 30 19:44:33 CEST 2012
 * @generated */
public class MatchResult_Type extends Result_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (MatchResult_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = MatchResult_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new MatchResult(addr, MatchResult_Type.this);
  			   MatchResult_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new MatchResult(addr, MatchResult_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = MatchResult.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.seemla.rssf.MatchResult");
 
  /** @generated */
  final Feature casFeat_result1;
  /** @generated */
  final int     casFeatCode_result1;
  /** @generated */ 
  public int getResult1(int addr) {
        if (featOkTst && casFeat_result1 == null)
      jcas.throwFeatMissing("result1", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_result1);
  }
  /** @generated */    
  public void setResult1(int addr, int v) {
        if (featOkTst && casFeat_result1 == null)
      jcas.throwFeatMissing("result1", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_result1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_result2;
  /** @generated */
  final int     casFeatCode_result2;
  /** @generated */ 
  public int getResult2(int addr) {
        if (featOkTst && casFeat_result2 == null)
      jcas.throwFeatMissing("result2", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_result2);
  }
  /** @generated */    
  public void setResult2(int addr, int v) {
        if (featOkTst && casFeat_result2 == null)
      jcas.throwFeatMissing("result2", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_result2, v);}
    
  
 
  /** @generated */
  final Feature casFeat_mid1;
  /** @generated */
  final int     casFeatCode_mid1;
  /** @generated */ 
  public int getMid1(int addr) {
        if (featOkTst && casFeat_mid1 == null)
      jcas.throwFeatMissing("mid1", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_mid1);
  }
  /** @generated */    
  public void setMid1(int addr, int v) {
        if (featOkTst && casFeat_mid1 == null)
      jcas.throwFeatMissing("mid1", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_mid1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_mid2;
  /** @generated */
  final int     casFeatCode_mid2;
  /** @generated */ 
  public int getMid2(int addr) {
        if (featOkTst && casFeat_mid2 == null)
      jcas.throwFeatMissing("mid2", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_mid2);
  }
  /** @generated */    
  public void setMid2(int addr, int v) {
        if (featOkTst && casFeat_mid2 == null)
      jcas.throwFeatMissing("mid2", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_mid2, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public MatchResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_result1 = jcas.getRequiredFeatureDE(casType, "result1", "uima.cas.Integer", featOkTst);
    casFeatCode_result1  = (null == casFeat_result1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_result1).getCode();

 
    casFeat_result2 = jcas.getRequiredFeatureDE(casType, "result2", "uima.cas.Integer", featOkTst);
    casFeatCode_result2  = (null == casFeat_result2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_result2).getCode();

 
    casFeat_mid1 = jcas.getRequiredFeatureDE(casType, "mid1", "uima.cas.Integer", featOkTst);
    casFeatCode_mid1  = (null == casFeat_mid1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mid1).getCode();

 
    casFeat_mid2 = jcas.getRequiredFeatureDE(casType, "mid2", "uima.cas.Integer", featOkTst);
    casFeatCode_mid2  = (null == casFeat_mid2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mid2).getCode();

  }
}



    