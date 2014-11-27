package com.job.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;








import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.rule.Package;








import com.job.model.Ambiente;


@Path("/msg")
@ViewScoped
@ManagedBean
public class Index {
	
	private Ambiente am;
	
	public Index(){
		am = new Ambiente();
	}
	
	@Path("{qntDePessoas}/{distancia}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response exec(@PathParam("qntDePessoas") int qntDePessoas,
			@PathParam("distancia") float distancia) throws Exception{
		WorkingMemory wm = (WorkingMemory) readRuleBase("rule.drl").newStatefulSession();
         
      
        am.setQntPessoas(qntDePessoas);
        am.setDistancia(distancia);
        
        wm.insert(am);

        wm.fireAllRules();
        
        JSONObject obj = new JSONObject();
        JSONObject ambiente = new JSONObject();
        try {
			obj.put("qntPessoas", am.getQntPessoas());
			obj.put("distancia", am.getDistancia());
			obj.put("lampada", am.isLampada());
			obj.put("ar-condicionado", am.isArCondicionado());
			
			ambiente.put("ambiente", obj);
		} catch (JSONException e) {
			e.getMessage();
		}
        
        return Response.status(200).entity(ambiente).build();
	}
	
	public RuleBase readRuleBase(String sourceDRL) throws DroolsParserException, IOException{
		Reader source = new InputStreamReader(Index.class.getResourceAsStream(sourceDRL));
		PackageBuilder builder = new PackageBuilder();
		builder.addPackageFromDrl(source);
		Package pkg = builder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(pkg);
		return ruleBase;
	}

	public Ambiente getAm() {
		return am;
	}

	public void setAm(Ambiente am) {
		this.am = am;
	}
	
	public void ae(){
		
	}
	
}
