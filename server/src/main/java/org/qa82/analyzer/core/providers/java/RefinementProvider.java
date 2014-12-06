/*******************************************************************************
* Copyright (c) 2014 Michael Gebhart (michael.gebhart@qa82.org).
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* Michael Gebhart - initial idea and concept
* 
*******************************************************************************/

package org.qa82.analyzer.core.providers.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.qa82.analyzer.core.Analyzer;
import org.qa82.analyzer.core.AnalyzerResult;
import org.qa82.analyzer.core.Information;
import org.qa82.analyzer.core.Parameters;
import org.qa82.analyzer.core.annotations.Parameter;
import org.qa82.analyzer.core.annotations.ProvidedFunction;
import org.qa82.analyzer.core.bean.InformationNeed;
import org.qa82.analyzer.core.bean.InformationType;
import org.qa82.analyzer.core.exceptions.InformationNeedNotResolvableException;
import org.qa82.analyzer.core.impl.AbstractInformationProvider;
import org.qa82.analyzer.core.impl.Element;
import org.qa82.analyzer.core.impl.EmptyInformation;
import org.qa82.analyzer.core.impl.EmptyParameters;
import org.qa82.analyzer.core.impl.SimpleInformation;

public class RefinementProvider extends AbstractInformationProvider {
	
	public RefinementProvider(Analyzer analyzer) {
		super(analyzer);
	}
	
	@ProvidedFunction
	public @Parameter(uri="test2") Object doSomething2(@Parameter(uri="") Object a) {
        return "L�uft2";
	}
	
	@ProvidedFunction
	public @Parameter(uri="test") Object doSomething(@Parameter(uri="") Object a) {
        return "L�uft";
	}
	
	@ProvidedFunction
    public @Parameter(uri = "operations") Information getAllProvidedOperations() throws InformationNeedNotResolvableException {
		List<Element> services = getServicesFromAnalyzer();
		
        List<Element> serviceOperations = new ArrayList<Element>();
        services.forEach((service) -> serviceOperations.add(getOperationsForServiceFromAnalyzer(service)));
			
        return new SimpleInformation(serviceOperations);
	}

    private Element getOperationsForServiceFromAnalyzer(Element service) {
        // TODO Auto-generated method stub
        return new Element("");
    }

    private List<Element> getServicesFromAnalyzer() throws InformationNeedNotResolvableException {
		List<Element> services = new ArrayList<Element>();
        AnalyzerResult result = analyzer.resolve(new InformationType(Element.class, "service"),
				new EmptyParameters());
        if (result.getInformation().isInformationPresent()) {

            // TODO: IMPLEMENT CONVERSION
		}

		return services;
	}

	@Override
	public Boolean provides(InformationType expectedInformation, Parameters parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Information resolve(InformationType expoectedInformation, Parameters parameters) {
		// TODO Auto-generated method stub
		return new EmptyInformation();
	}

	@Override
    public Set<InformationNeed> getProvidedInformation() {
		// TODO Auto-generated method stub
		return new HashSet<InformationNeed>();
	}
}
