package com.fullcreative.sriramnsm;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class HelloAppEngineTest {

  @Test
  public void test() throws IOException {
    MockHttpServletResponse response = new MockHttpServletResponse();
	MockHttpServletRequest request = new MockHttpServletRequest();
	request.setContentType("application/json");
	new HelloAppEngine().doGet(request, response);
	Assert.assertEquals("application/json", request.getContentType());
    Assert.assertEquals("UTF-8", response.getCharacterEncoding());
    Assert.assertEquals("Hello App Engine!\r\n", response.getWriterContent().toString());
  }
}
