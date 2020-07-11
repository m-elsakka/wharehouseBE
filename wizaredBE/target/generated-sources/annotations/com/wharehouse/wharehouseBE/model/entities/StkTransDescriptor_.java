package com.wharehouse.wharehouseBE.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StkTransDescriptor.class)
public abstract class StkTransDescriptor_ {

	public static volatile SingularAttribute<StkTransDescriptor, Character> applyDefaCAcc;
	public static volatile SingularAttribute<StkTransDescriptor, Character> oneSide;
	public static volatile SingularAttribute<StkTransDescriptor, String> transDescNamee;
	public static volatile SingularAttribute<StkTransDescriptor, StkAccounts> accountD;
	public static volatile SingularAttribute<StkTransDescriptor, String> transDescTitlee;
	public static volatile SingularAttribute<StkTransDescriptor, StkAccounts> accountC;
	public static volatile SingularAttribute<StkTransDescriptor, Character> applyDefaDAcc;
	public static volatile SingularAttribute<StkTransDescriptor, Branch> branch;
	public static volatile SingularAttribute<StkTransDescriptor, StkTransDescriptorPK> stkTransDescriptorPK;
	public static volatile SingularAttribute<StkTransDescriptor, String> transDescTitlea;
	public static volatile SingularAttribute<StkTransDescriptor, String> defaCGroup;
	public static volatile SingularAttribute<StkTransDescriptor, Character> packingslipOperation;
	public static volatile SingularAttribute<StkTransDescriptor, String> transDescNamea;
	public static volatile SingularAttribute<StkTransDescriptor, String> defaDGroup;
	public static volatile SingularAttribute<StkTransDescriptor, Character> hasCar;

	public static final String APPLY_DEFA_CACC = "applyDefaCAcc";
	public static final String ONE_SIDE = "oneSide";
	public static final String TRANS_DESC_NAMEE = "transDescNamee";
	public static final String ACCOUNT_D = "accountD";
	public static final String TRANS_DESC_TITLEE = "transDescTitlee";
	public static final String ACCOUNT_C = "accountC";
	public static final String APPLY_DEFA_DACC = "applyDefaDAcc";
	public static final String BRANCH = "branch";
	public static final String STK_TRANS_DESCRIPTOR_PK = "stkTransDescriptorPK";
	public static final String TRANS_DESC_TITLEA = "transDescTitlea";
	public static final String DEFA_CGROUP = "defaCGroup";
	public static final String PACKINGSLIP_OPERATION = "packingslipOperation";
	public static final String TRANS_DESC_NAMEA = "transDescNamea";
	public static final String DEFA_DGROUP = "defaDGroup";
	public static final String HAS_CAR = "hasCar";

}

