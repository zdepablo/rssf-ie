
/* First created by JCasGen Tue May 15 20:27:33 CEST 2012 */
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
 * Updated by JCasGen Wed May 16 13:18:25 CEST 2012
 * @generated */
public class Competition_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Competition_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Competition_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Competition(addr, Competition_Type.this);
  			   Competition_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Competition(addr, Competition_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Competition.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("com.seemla.rssf.Competition");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "com.seemla.rssf.Competition");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "com.seemla.rssf.Competition");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_year;
  /** @generated */
  final int     casFeatCode_year;
  /** @generated */ 
  public String getYear(int addr) {
        if (featOkTst && casFeat_year == null)
      jcas.throwFeatMissing("year", "com.seemla.rssf.Competition");
    return ll_cas.ll_getStringValue(addr, casFeatCode_year);
  }
  /** @generated */    
  public void setYear(int addr, String v) {
        if (featOkTst && casFeat_year == null)
      jcas.throwFeatMissing("year", "com.seemla.rssf.Competition");
    ll_cas.ll_setStringValue(addr, casFeatCode_year, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Competition_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_year = jcas.getRequiredFeatureDE(casType, "year", "uima.cas.String", featOkTst);
    casFeatCode_year  = (null == casFeat_year) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_year).getCode();

  }
}



    