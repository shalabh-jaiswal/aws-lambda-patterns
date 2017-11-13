package us.shalabh.alp.function;

import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;

import us.shalabh.alp.service.IDemoS3EventService;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
@RunWith(MockitoJUnitRunner.class)
public class DemoS3EventLambdaTest
{

	private final String CONTENT_TYPE = "image/jpeg";
	private S3Event event;

	@Mock
	private AmazonS3 s3Client;
	@Mock
	private S3Object s3Object;

	@Mock
	private IDemoS3EventService mockDemoS3EventService;

	@InjectMocks
	private DemoS3EventLambda lambda;

	@Captor
	private ArgumentCaptor<GetObjectRequest> getObjectRequest;

	@Before
	public void setUp() throws IOException
	{
		event = TestUtils.parse("/s3-event.put.json", S3Event.class);

		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentType(CONTENT_TYPE);
		when(s3Object.getObjectMetadata()).thenReturn(objectMetadata);
		when(s3Client.getObject(getObjectRequest.capture())).thenReturn(s3Object);
	}

	private Context createContext()
	{
		TestContext ctx = new TestContext();
		ctx.setFunctionName("Your Function Name");

		return ctx;
	}

	@Test
	public void testDemoS3EventLambda()
	{
		Context ctx = createContext();

		Mockito.when(mockDemoS3EventService.getData()).thenReturn("Mock Data");

		String data = lambda.process(event, ctx);

		Assert.assertEquals("Mock Data", data);
	}
}
