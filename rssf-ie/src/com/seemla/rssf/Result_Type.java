
/* First created by JCasGen Wed May 30 19:40:54 CEST 2012 */
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
public class Result_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Result_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Result_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Result(addr, Result_Type.this);
  			   Result_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Result(addr, Result_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Result.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.seemla.rssf.Result");
 
  /** @generated */
  final Feature casFeat_team1;
  /** @generated */
  final int     casFeatCode_team1;
  /** @generated */ 
  public String getTeam1(int addr) {
        if (featOkTst && casFeat_team1 == null)
      jcas.throwFeatMissing("team1", "com.seemla.rssf.Result");
    return ll_cas.ll_getStringValue(addr, casFeatCode_team1);
  }
  /** @generated */    
  public void setTeam1(int addr, String v) {
        if (featOkTst && casFeat_team1 == null)
      jcas.throwFeatMissing("team1", "com.seemla.rssf.Result");
    ll_cas.ll_setStringValue(addr, casFeatCode_team1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_team2;
  /** @generated */
  final int     casFeatCode_team2;
  /** @generated */ 
  public String getTeam2(int addr) {
        if (featOkTst && casFeat_team2 == null)
      jcas.throwFeatMissing("team2", "com.seemla.rssf.Result");
    return ll_cas.ll_getStringValue(addr, casFeatCode_team2);
  }
  /** @generated */    
  public void setTeam2(int addr, String v) {
        if (featOkTst && casFeat_team2 == null)
      jcas.throwFeatMissing("team2", "com.seemla.rssf.Result");
    ll_cas.ll_setStringValue(addr, casFeatCode_team2, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Result_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_team1 = jcas.getRequiredFeatureDE(casType, "team1", "uima.cas.String", featOkTst);
    casFeatCode_team1  = (null == casFeat_team1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_team1).getCode();

 
    casFeat_team2 = jcas.getRequiredFeatureDE(casType, "team2", "uima.cas.String", featOkTst);
    casFeatCode_team2  = (null == casFeat_team2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_team2).getCode();

  }
}



    