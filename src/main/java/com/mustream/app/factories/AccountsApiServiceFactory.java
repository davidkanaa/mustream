package com.mustream.app.factories;

import com.mustream.api.AccountsApiService;
import com.mustream.app.impl.AccountsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class AccountsApiServiceFactory {

   private final static AccountsApiService service = new AccountsApiServiceImpl();

   public static AccountsApiService getAccountsApi()
   {
      return service;
   }
}
