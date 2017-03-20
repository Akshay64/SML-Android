package com.sml.testcases;

import org.testng.annotations.Test;

import com.sml.classes.AddResources;

public class VerifyAddResourcesLaunch {
	AddResources addResources = new AddResources();
  @Test(priority = 1)
  public void verifyAddResourcesLaunch() throws Exception {
	  addResources.verifyAddResourcesLaunch();
  }
}
