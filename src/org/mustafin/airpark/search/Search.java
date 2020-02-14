/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mustafin.airpark.search;

import java.util.Collection;
import org.mustafin.airpark.airship.AbstractAirship;
import org.mustafin.airpark.company.AbstractCompany;
import org.mustafin.airpark.search.util.SearchInputParameters;

/**
 *
 * @author Marat_Mustafin
 */
public interface Search {
    Collection<AbstractAirship> search(Collection<AbstractCompany> companies, SearchInputParameters sip);
}
