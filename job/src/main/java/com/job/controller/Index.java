package com.job.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.rule.Package;


import com.job.model.Ambiente;


@Path("/msg")
@RequestScoped
@ManagedBean
public class Index {
	
	@Path("/{qntDePessoas}/{lampada}/{arCondicionado}/{distancia}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response exec(@PathParam("qntDePessoas") int qntDePessoas,
			@PathParam("lampada") boolean lampada,
			@PathParam("arCondicionado") boolean arCondicionado,
			@PathParam("distancia") float distancia) throws Exception{
		WorkingMemory wm = (WorkingMemory) readRuleBase("rule.drl").newStatefulSession();
        
        Ambiente am = new Ambiente();
        am.setQntPessoas(qntDePessoas);
        am.setLampada(lampada);
        am.setArCondicionado(arCondicionado);
        am.setDistancia(distancia);
        
        wm.insert(am);

        wm.fireAllRules();
        
        
        return Response.status(200).entity("Alteracao feita com sucesso!").build();
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
	
}
