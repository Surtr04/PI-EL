import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.text.GapContent;

import language.* ;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
//import org.antlr.stringtemplate.*;

import parsing.*;
import graphs.cfg.*;
import graphs.pdg.PDG;
import graphviz.GraphViz;


public class Run {
	
	public static void main(String[] args) throws Exception {
		try{
			CharStream in = new ANTLRFileStream(args[0], "UTF8");
			CmbLexer lexer = new CmbLexer(in);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
	 		
			CmbParser parser = new CmbParser(tokens);
			CmbParser.programa_return ret = parser.programa();
			
						
			//System.out.println(((CommonTree)ret.getTree()).toStringTree());
			CommonTreeNodeStream tree = new CommonTreeNodeStream(ret.getTree());
			CmbTG22 walker_tabid = new CmbTG22(tree);
			Tabela walker_ret = walker_tabid.programa();
			
			tree = new CommonTreeNodeStream(ret.getTree());
			CmbTG_ver_sem walker_ver_sem = new CmbTG_ver_sem(tree);
			walker_ver_sem.programa(walker_ret);
			
			System.out.println("Errors:" + walker_ver_sem.getErrors());
			
			tree = new CommonTreeNodeStream(ret.getTree());
			CmbTG_CFG walker_CFG = new CmbTG_CFG(tree);
			HashMap<String, CFG> cs =  walker_CFG.programa();
			
			GraphViz gv;
			String type = "png";
			String path = new File(".").getCanonicalPath();
			GraphViz.TEMP_DIR = path;
			GraphViz.DOT = "C:\\Program Files (x86)\\Graphviz 2.28\\bin\\dot";
			File out;
			System.out.println(path);
			for(Entry<String,CFG> c : cs.entrySet()){
				gv = new GraphViz();
				c.getValue().setShowDefsRefs(false);
				gv.addln(c.getValue().toDotDigraph(c.getKey()));
				//System.out.println(gv.getDotSource());
				out = new File(path + System.getProperty("file.separator") + "cfg_" + c.getKey() + "." + type);
				gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
			}
			
			
			HashMap<String, PDG> ps = new HashMap<>();
			PDG p;
			for(Entry<String,CFG> c : cs.entrySet()){
				gv = new GraphViz();
				p = new PDG(c.getValue());
				ps.put(c.getKey(), p);
				gv.addln(p.toDotDigraph(c.getKey()));
				System.out.println(gv.getDotSource());
				out = new File(path + System.getProperty("file.separator") + "pdg_" + c.getKey() + "." + type);
				gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
			}
			//System.out.println(walker_ret);
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
