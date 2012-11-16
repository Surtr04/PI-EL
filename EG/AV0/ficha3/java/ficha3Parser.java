// $ANTLR 3.4 /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g 2012-11-16 15:30:59

import java.util.HashMap;
import java.util.Map;
	


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ficha3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ESC_SEQ", "EXPONENT", "FLOAT", "HEX_DIGIT", "ID", "OCTAL_ESC", "STR", "UNICODE_ESC", "WS", "'('", "')'", "','", "'---'", "'.'", "';'"
    };

    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int ESC_SEQ=4;
    public static final int EXPONENT=5;
    public static final int FLOAT=6;
    public static final int HEX_DIGIT=7;
    public static final int ID=8;
    public static final int OCTAL_ESC=9;
    public static final int STR=10;
    public static final int UNICODE_ESC=11;
    public static final int WS=12;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public ficha3Parser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ficha3Parser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return ficha3Parser.tokenNames; }
    public String getGrammarFileName() { return "/home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g"; }


    	class Artigos{
    		public String codigo;
    		public String designacao;
    		public Double preco;
    		public Double stock;
    		public Artigos(String c, String d, Double p, Double s){this.codigo = c; this.designacao = d; this.preco = p; this.stock = s;}
    	}
    	
    	private HashMap<String,ArrayList<Double>> _totais;
    	private HashMap<String,Artigos> _artigos;
    	private String _fct;



    // $ANTLR start "facturas"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:28:1: facturas : ( descs )+ '---' factura ( ';' factura )* '.' ;
    public final void facturas() throws RecognitionException {
        this._totais = new HashMap<String, ArrayList<Double>>(); this._artigos = new HashMap<String,Artigos>();
        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:56:2: ( ( descs )+ '---' factura ( ';' factura )* '.' )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:56:4: ( descs )+ '---' factura ( ';' factura )* '.'
            {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:56:4: ( descs )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:56:4: descs
            	    {
            	    pushFollow(FOLLOW_descs_in_facturas46);
            	    descs();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            match(input,16,FOLLOW_16_in_facturas49); 

            pushFollow(FOLLOW_factura_in_facturas51);
            factura();

            state._fsp--;


            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:56:25: ( ';' factura )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:56:26: ';' factura
            	    {
            	    match(input,18,FOLLOW_18_in_facturas54); 

            	    pushFollow(FOLLOW_factura_in_facturas56);
            	    factura();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,17,FOLLOW_17_in_facturas60); 

            }


                int i;
                Double soma;
                for (Map.Entry<String, ArrayList<Double>> entry : this._totais.entrySet()) { 
                	System.out.println("Factura " + entry.getKey()); 
                	i = 0; 
                	soma = 0.0;
                	for(Double d : entry.getValue()){
                		i++;
                		soma += d;
                		System.out.println("\tLinha " + i + ": " + d.toString());
                	}
                	System.out.println("Total factura: " + soma);
                	System.out.println("----------------------");
                }
                System.out.println("");
                System.out.println("==============================");
                System.out.println("");
                for (Artigos a : this._artigos.values()){
                	System.out.println("Artigo " + a.codigo);
                	System.out.println("\tDesignacao: " + a.designacao);
                	System.out.println("\tPreço: " + a.preco);
                	System.out.println("\tStock: " + a.stock);
                	System.out.println("----------------------");
                }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "facturas"



    // $ANTLR start "descs"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:59:1: descs : codartigo designacao pvu stock ;
    public final void descs() throws RecognitionException {
        ficha3Parser.codartigo_return codartigo1 =null;

        ficha3Parser.designacao_return designacao2 =null;

        ficha3Parser.pvu_return pvu3 =null;

        ficha3Parser.stock_return stock4 =null;


        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:60:2: ( codartigo designacao pvu stock )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:60:5: codartigo designacao pvu stock
            {
            pushFollow(FOLLOW_codartigo_in_descs72);
            codartigo1=codartigo();

            state._fsp--;


            pushFollow(FOLLOW_designacao_in_descs74);
            designacao2=designacao();

            state._fsp--;


            pushFollow(FOLLOW_pvu_in_descs76);
            pvu3=pvu();

            state._fsp--;


            pushFollow(FOLLOW_stock_in_descs78);
            stock4=stock();

            state._fsp--;



            		String c = (codartigo1!=null?input.toString(codartigo1.start,codartigo1.stop):null);
            		String d = (designacao2!=null?input.toString(designacao2.start,designacao2.stop):null);
            		Double p = Double.parseDouble((pvu3!=null?input.toString(pvu3.start,pvu3.stop):null));
            		Double s = Double.parseDouble((stock4!=null?input.toString(stock4.start,stock4.stop):null));
            		this._artigos.put(c, new Artigos(c, d, p, s));
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "descs"



    // $ANTLR start "factura"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:69:1: factura : cabec corpo ;
    public final void factura() throws RecognitionException {
        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:70:2: ( cabec corpo )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:70:4: cabec corpo
            {
            pushFollow(FOLLOW_cabec_in_factura91);
            cabec();

            state._fsp--;


            pushFollow(FOLLOW_corpo_in_factura93);
            corpo();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "factura"



    // $ANTLR start "cabec"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:73:1: cabec : idfact ide idr ;
    public final void cabec() throws RecognitionException {
        ficha3Parser.idfact_return idfact5 =null;


        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:74:2: ( idfact ide idr )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:74:4: idfact ide idr
            {
            pushFollow(FOLLOW_idfact_in_cabec105);
            idfact5=idfact();

            state._fsp--;


            this._fct = (idfact5!=null?input.toString(idfact5.start,idfact5.stop):null); this._totais.put(this._fct, new ArrayList<Double>());

            pushFollow(FOLLOW_ide_in_cabec109);
            ide();

            state._fsp--;


            pushFollow(FOLLOW_idr_in_cabec111);
            idr();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "cabec"



    // $ANTLR start "corpo"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:77:1: corpo : ( linha )+ ;
    public final void corpo() throws RecognitionException {
        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:78:2: ( ( linha )+ )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:78:4: ( linha )+
            {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:78:4: ( linha )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:78:4: linha
            	    {
            	    pushFollow(FOLLOW_linha_in_corpo123);
            	    linha();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "corpo"



    // $ANTLR start "linha"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:82:1: linha : '(' codartigo ',' quantidade ')' ;
    public final void linha() throws RecognitionException {
        ficha3Parser.quantidade_return quantidade6 =null;

        ficha3Parser.codartigo_return codartigo7 =null;


        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:83:2: ( '(' codartigo ',' quantidade ')' )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:83:4: '(' codartigo ',' quantidade ')'
            {
            match(input,13,FOLLOW_13_in_linha138); 

            pushFollow(FOLLOW_codartigo_in_linha140);
            codartigo7=codartigo();

            state._fsp--;


            match(input,15,FOLLOW_15_in_linha142); 

            pushFollow(FOLLOW_quantidade_in_linha144);
            quantidade6=quantidade();

            state._fsp--;


            match(input,14,FOLLOW_14_in_linha146); 


            			Double qt = Double.parseDouble((quantidade6!=null?input.toString(quantidade6.start,quantidade6.stop):null));
            			Artigos ag = this._artigos.get((codartigo7!=null?input.toString(codartigo7.start,codartigo7.stop):null));
            			this._totais.get(this._fct).add(ag.preco * qt);
            			ag.stock -= qt;
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "linha"


    public static class codartigo_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "codartigo"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:91:1: codartigo : ID ;
    public final ficha3Parser.codartigo_return codartigo() throws RecognitionException {
        ficha3Parser.codartigo_return retval = new ficha3Parser.codartigo_return();
        retval.start = input.LT(1);


        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:92:2: ( ID )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:92:4: ID
            {
            match(input,ID,FOLLOW_ID_in_codartigo161); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "codartigo"


    public static class designacao_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "designacao"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:94:1: designacao : STR ;
    public final ficha3Parser.designacao_return designacao() throws RecognitionException {
        ficha3Parser.designacao_return retval = new ficha3Parser.designacao_return();
        retval.start = input.LT(1);


        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:95:2: ( STR )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:95:4: STR
            {
            match(input,STR,FOLLOW_STR_in_designacao170); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "designacao"


    public static class pvu_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "pvu"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:97:1: pvu : FLOAT ;
    public final ficha3Parser.pvu_return pvu() throws RecognitionException {
        ficha3Parser.pvu_return retval = new ficha3Parser.pvu_return();
        retval.start = input.LT(1);


        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:97:5: ( FLOAT )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:97:7: FLOAT
            {
            match(input,FLOAT,FOLLOW_FLOAT_in_pvu179); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pvu"


    public static class stock_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "stock"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:99:1: stock : FLOAT ;
    public final ficha3Parser.stock_return stock() throws RecognitionException {
        ficha3Parser.stock_return retval = new ficha3Parser.stock_return();
        retval.start = input.LT(1);


        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:100:2: ( FLOAT )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:100:4: FLOAT
            {
            match(input,FLOAT,FOLLOW_FLOAT_in_stock188); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stock"


    public static class quantidade_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "quantidade"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:102:1: quantidade : FLOAT ;
    public final ficha3Parser.quantidade_return quantidade() throws RecognitionException {
        ficha3Parser.quantidade_return retval = new ficha3Parser.quantidade_return();
        retval.start = input.LT(1);


        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:103:2: ( FLOAT )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:103:4: FLOAT
            {
            match(input,FLOAT,FOLLOW_FLOAT_in_quantidade197); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "quantidade"


    public static class idfact_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "idfact"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:106:1: idfact : numfact ;
    public final ficha3Parser.idfact_return idfact() throws RecognitionException {
        ficha3Parser.idfact_return retval = new ficha3Parser.idfact_return();
        retval.start = input.LT(1);


        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:107:2: ( numfact )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:107:4: numfact
            {
            pushFollow(FOLLOW_numfact_in_idfact208);
            numfact();

            state._fsp--;


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "idfact"



    // $ANTLR start "numfact"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:110:1: numfact : ID ;
    public final void numfact() throws RecognitionException {
        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:111:2: ( ID )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:111:4: ID
            {
            match(input,ID,FOLLOW_ID_in_numfact220); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "numfact"



    // $ANTLR start "ide"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:115:1: ide : nome nif morada nib ;
    public final void ide() throws RecognitionException {
        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:115:5: ( nome nif morada nib )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:115:7: nome nif morada nib
            {
            pushFollow(FOLLOW_nome_in_ide232);
            nome();

            state._fsp--;


            pushFollow(FOLLOW_nif_in_ide234);
            nif();

            state._fsp--;


            pushFollow(FOLLOW_morada_in_ide236);
            morada();

            state._fsp--;


            pushFollow(FOLLOW_nib_in_ide238);
            nib();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ide"



    // $ANTLR start "nome"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:117:1: nome : STR ;
    public final void nome() throws RecognitionException {
        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:117:5: ( STR )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:117:7: STR
            {
            match(input,STR,FOLLOW_STR_in_nome246); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "nome"



    // $ANTLR start "nif"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:118:1: nif : STR ;
    public final void nif() throws RecognitionException {
        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:118:5: ( STR )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:118:7: STR
            {
            match(input,STR,FOLLOW_STR_in_nif253); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "nif"



    // $ANTLR start "morada"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:119:1: morada : STR ;
    public final void morada() throws RecognitionException {
        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:120:2: ( STR )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:120:4: STR
            {
            match(input,STR,FOLLOW_STR_in_morada261); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "morada"



    // $ANTLR start "nib"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:121:1: nib : STR ;
    public final void nib() throws RecognitionException {
        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:121:5: ( STR )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:121:7: STR
            {
            match(input,STR,FOLLOW_STR_in_nib268); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "nib"



    // $ANTLR start "idr"
    // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:122:1: idr : nome nif morada ;
    public final void idr() throws RecognitionException {
        try {
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:122:5: ( nome nif morada )
            // /home/anolsi/EL/PI-EL/EG/AV0/ficha3/ficha3.g:122:7: nome nif morada
            {
            pushFollow(FOLLOW_nome_in_idr276);
            nome();

            state._fsp--;


            pushFollow(FOLLOW_nif_in_idr278);
            nif();

            state._fsp--;


            pushFollow(FOLLOW_morada_in_idr280);
            morada();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "idr"

    // Delegated rules


 

    public static final BitSet FOLLOW_descs_in_facturas46 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_16_in_facturas49 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_factura_in_facturas51 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_facturas54 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_factura_in_facturas56 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_facturas60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_codartigo_in_descs72 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_designacao_in_descs74 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_pvu_in_descs76 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_stock_in_descs78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cabec_in_factura91 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_corpo_in_factura93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idfact_in_cabec105 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ide_in_cabec109 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_idr_in_cabec111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linha_in_corpo123 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_linha138 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_codartigo_in_linha140 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_linha142 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_quantidade_in_linha144 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_linha146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_codartigo161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_designacao170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_pvu179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_stock188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_quantidade197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numfact_in_idfact208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_numfact220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nome_in_ide232 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_nif_in_ide234 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_morada_in_ide236 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_nib_in_ide238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_nome246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_nif253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_morada261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_nib268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nome_in_idr276 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_nif_in_idr278 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_morada_in_idr280 = new BitSet(new long[]{0x0000000000000002L});

}