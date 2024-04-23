package im;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: ProductManagementService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductManagementServiceGrpc {

  private ProductManagementServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "im.ProductManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<im.ProductManagementServiceOuterClass.AddProductRequest,
      im.ProductManagementServiceOuterClass.AddProductResponse> getAddProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addProduct",
      requestType = im.ProductManagementServiceOuterClass.AddProductRequest.class,
      responseType = im.ProductManagementServiceOuterClass.AddProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<im.ProductManagementServiceOuterClass.AddProductRequest,
      im.ProductManagementServiceOuterClass.AddProductResponse> getAddProductMethod() {
    io.grpc.MethodDescriptor<im.ProductManagementServiceOuterClass.AddProductRequest, im.ProductManagementServiceOuterClass.AddProductResponse> getAddProductMethod;
    if ((getAddProductMethod = ProductManagementServiceGrpc.getAddProductMethod) == null) {
      synchronized (ProductManagementServiceGrpc.class) {
        if ((getAddProductMethod = ProductManagementServiceGrpc.getAddProductMethod) == null) {
          ProductManagementServiceGrpc.getAddProductMethod = getAddProductMethod =
              io.grpc.MethodDescriptor.<im.ProductManagementServiceOuterClass.AddProductRequest, im.ProductManagementServiceOuterClass.AddProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.ProductManagementServiceOuterClass.AddProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.ProductManagementServiceOuterClass.AddProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductManagementServiceMethodDescriptorSupplier("addProduct"))
              .build();
        }
      }
    }
    return getAddProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductManagementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductManagementServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductManagementServiceStub>() {
        @java.lang.Override
        public ProductManagementServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductManagementServiceStub(channel, callOptions);
        }
      };
    return ProductManagementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductManagementServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductManagementServiceBlockingStub>() {
        @java.lang.Override
        public ProductManagementServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductManagementServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductManagementServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductManagementServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductManagementServiceFutureStub>() {
        @java.lang.Override
        public ProductManagementServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductManagementServiceFutureStub(channel, callOptions);
        }
      };
    return ProductManagementServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addProduct(im.ProductManagementServiceOuterClass.AddProductRequest request,
        io.grpc.stub.StreamObserver<im.ProductManagementServiceOuterClass.AddProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddProductMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductManagementService.
   */
  public static abstract class ProductManagementServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProductManagementServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductManagementService.
   */
  public static final class ProductManagementServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductManagementServiceStub> {
    private ProductManagementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductManagementServiceStub(channel, callOptions);
    }

    /**
     */
    public void addProduct(im.ProductManagementServiceOuterClass.AddProductRequest request,
        io.grpc.stub.StreamObserver<im.ProductManagementServiceOuterClass.AddProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductManagementService.
   */
  public static final class ProductManagementServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductManagementServiceBlockingStub> {
    private ProductManagementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductManagementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public im.ProductManagementServiceOuterClass.AddProductResponse addProduct(im.ProductManagementServiceOuterClass.AddProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddProductMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductManagementService.
   */
  public static final class ProductManagementServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductManagementServiceFutureStub> {
    private ProductManagementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductManagementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductManagementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<im.ProductManagementServiceOuterClass.AddProductResponse> addProduct(
        im.ProductManagementServiceOuterClass.AddProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PRODUCT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PRODUCT:
          serviceImpl.addProduct((im.ProductManagementServiceOuterClass.AddProductRequest) request,
              (io.grpc.stub.StreamObserver<im.ProductManagementServiceOuterClass.AddProductResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              im.ProductManagementServiceOuterClass.AddProductRequest,
              im.ProductManagementServiceOuterClass.AddProductResponse>(
                service, METHODID_ADD_PRODUCT)))
        .build();
  }

  private static abstract class ProductManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return im.ProductManagementServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductManagementService");
    }
  }

  private static final class ProductManagementServiceFileDescriptorSupplier
      extends ProductManagementServiceBaseDescriptorSupplier {
    ProductManagementServiceFileDescriptorSupplier() {}
  }

  private static final class ProductManagementServiceMethodDescriptorSupplier
      extends ProductManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProductManagementServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductManagementServiceFileDescriptorSupplier())
              .addMethod(getAddProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
