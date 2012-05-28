
/* First created by JCasGen Mon May 14 21:00:44 CEST 2012 */
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
 * Updated by JCasGen Mon May 28 19:36:37 CEST 2012
 * @generated */
public class MatchResult_Type extends Annotation_Type {
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
  final Feature casFeat_team1;
  /** @generated */
  final int     casFeatCode_team1;
  /** @generated */ 
  public String getTeam1(int addr) {
        if (featOkTst && casFeat_team1 == null)
      jcas.throwFeatMissing("team1", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_team1);
  }
  /** @generated */    
  public void setTeam1(int addr, String v) {
        if (featOkTst && casFeat_team1 == null)
      jcas.throwFeatMissing("team1", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_team1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_country1;
  /** @generated */
  final int     casFeatCode_country1;
  /** @generated */ 
  public String getCountry1(int addr) {
        if (featOkTst && casFeat_country1 == null)
      jcas.throwFeatMissing("country1", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_country1);
  }
  /** @generated */    
  public void setCountry1(int addr, String v) {
        if (featOkTst && casFeat_country1 == null)
      jcas.throwFeatMissing("country1", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_country1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_team2;
  /** @generated */
  final int     casFeatCode_team2;
  /** @generated */ 
  public String getTeam2(int addr) {
        if (featOkTst && casFeat_team2 == null)
      jcas.throwFeatMissing("team2", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_team2);
  }
  /** @generated */    
  public void setTeam2(int addr, String v) {
        if (featOkTst && casFeat_team2 == null)
      jcas.throwFeatMissing("team2", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_team2, v);}
    
  
 
  /** @generated */
  final Feature casFeat_country2;
  /** @generated */
  final int     casFeatCode_country2;
  /** @generated */ 
  public String getCountry2(int addr) {
        if (featOkTst && casFeat_country2 == null)
      jcas.throwFeatMissing("country2", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_country2);
  }
  /** @generated */    
  public void setCountry2(int addr, String v) {
        if (featOkTst && casFeat_country2 == null)
      jcas.throwFeatMissing("country2", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_country2, v);}
    
  
 
  /** @generated */
  final Feature casFeat_leg1_1;
  /** @generated */
  final int     casFeatCode_leg1_1;
  /** @generated */ 
  public int getLeg1_1(int addr) {
        if (featOkTst && casFeat_leg1_1 == null)
      jcas.throwFeatMissing("leg1_1", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_leg1_1);
  }
  /** @generated */    
  public void setLeg1_1(int addr, int v) {
        if (featOkTst && casFeat_leg1_1 == null)
      jcas.throwFeatMissing("leg1_1", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_leg1_1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_leg1_2;
  /** @generated */
  final int     casFeatCode_leg1_2;
  /** @generated */ 
  public int getLeg1_2(int addr) {
        if (featOkTst && casFeat_leg1_2 == null)
      jcas.throwFeatMissing("leg1_2", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_leg1_2);
  }
  /** @generated */    
  public void setLeg1_2(int addr, int v) {
        if (featOkTst && casFeat_leg1_2 == null)
      jcas.throwFeatMissing("leg1_2", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_leg1_2, v);}
    
  
 
  /** @generated */
  final Feature casFeat_leg2_1;
  /** @generated */
  final int     casFeatCode_leg2_1;
  /** @generated */ 
  public int getLeg2_1(int addr) {
        if (featOkTst && casFeat_leg2_1 == null)
      jcas.throwFeatMissing("leg2_1", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_leg2_1);
  }
  /** @generated */    
  public void setLeg2_1(int addr, int v) {
        if (featOkTst && casFeat_leg2_1 == null)
      jcas.throwFeatMissing("leg2_1", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_leg2_1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_leg2_2;
  /** @generated */
  final int     casFeatCode_leg2_2;
  /** @generated */ 
  public int getLeg2_2(int addr) {
        if (featOkTst && casFeat_leg2_2 == null)
      jcas.throwFeatMissing("leg2_2", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_leg2_2);
  }
  /** @generated */    
  public void setLeg2_2(int addr, int v) {
        if (featOkTst && casFeat_leg2_2 == null)
      jcas.throwFeatMissing("leg2_2", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_leg2_2, v);}
    
  
 
  /** @generated */
  final Feature casFeat_total_1;
  /** @generated */
  final int     casFeatCode_total_1;
  /** @generated */ 
  public int getTotal_1(int addr) {
        if (featOkTst && casFeat_total_1 == null)
      jcas.throwFeatMissing("total_1", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_total_1);
  }
  /** @generated */    
  public void setTotal_1(int addr, int v) {
        if (featOkTst && casFeat_total_1 == null)
      jcas.throwFeatMissing("total_1", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_total_1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_total_2;
  /** @generated */
  final int     casFeatCode_total_2;
  /** @generated */ 
  public int getTotal_2(int addr) {
        if (featOkTst && casFeat_total_2 == null)
      jcas.throwFeatMissing("total_2", "com.seemla.rssf.MatchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_total_2);
  }
  /** @generated */    
  public void setTotal_2(int addr, int v) {
        if (featOkTst && casFeat_total_2 == null)
      jcas.throwFeatMissing("total_2", "com.seemla.rssf.MatchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_total_2, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public MatchResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_team1 = jcas.getRequiredFeatureDE(casType, "team1", "uima.cas.String", featOkTst);
    casFeatCode_team1  = (null == casFeat_team1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_team1).getCode();

 
    casFeat_country1 = jcas.getRequiredFeatureDE(casType, "country1", "uima.cas.String", featOkTst);
    casFeatCode_country1  = (null == casFeat_country1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_country1).getCode();

 
    casFeat_team2 = jcas.getRequiredFeatureDE(casType, "team2", "uima.cas.String", featOkTst);
    casFeatCode_team2  = (null == casFeat_team2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_team2).getCode();

 
    casFeat_country2 = jcas.getRequiredFeatureDE(casType, "country2", "uima.cas.String", featOkTst);
    casFeatCode_country2  = (null == casFeat_country2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_country2).getCode();

 
    casFeat_leg1_1 = jcas.getRequiredFeatureDE(casType, "leg1_1", "uima.cas.Integer", featOkTst);
    casFeatCode_leg1_1  = (null == casFeat_leg1_1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_leg1_1).getCode();

 
    casFeat_leg1_2 = jcas.getRequiredFeatureDE(casType, "leg1_2", "uima.cas.Integer", featOkTst);
    casFeatCode_leg1_2  = (null == casFeat_leg1_2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_leg1_2).getCode();

 
    casFeat_leg2_1 = jcas.getRequiredFeatureDE(casType, "leg2_1", "uima.cas.Integer", featOkTst);
    casFeatCode_leg2_1  = (null == casFeat_leg2_1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_leg2_1).getCode();

 
    casFeat_leg2_2 = jcas.getRequiredFeatureDE(casType, "leg2_2", "uima.cas.Integer", featOkTst);
    casFeatCode_leg2_2  = (null == casFeat_leg2_2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_leg2_2).getCode();

 
    casFeat_total_1 = jcas.getRequiredFeatureDE(casType, "total_1", "uima.cas.Integer", featOkTst);
    casFeatCode_total_1  = (null == casFeat_total_1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_total_1).getCode();

 
    casFeat_total_2 = jcas.getRequiredFeatureDE(casType, "total_2", "uima.cas.Integer", featOkTst);
    casFeatCode_total_2  = (null == casFeat_total_2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_total_2).getCode();

  }
}



    