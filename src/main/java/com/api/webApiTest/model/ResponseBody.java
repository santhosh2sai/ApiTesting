package com.api.webApiTest.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseBody {

	public String BrandName;
	public String Id;
	public String LaptopName;
	public Features	feature;
}

class Features {
	public List<String> feature = new ArrayList<>();
}