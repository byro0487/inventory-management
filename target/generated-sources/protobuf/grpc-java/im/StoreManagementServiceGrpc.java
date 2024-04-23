package im;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: StoreManagementService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StoreManagementServiceGrpc {

  private StoreManagementServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "im.StoreManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<im.StoreManagementServiceOuterClass.AddStoreRequest,
      im.StoreManagementServiceOuterClass.AddStoreResponse> getAddStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addStore",
      requestType = im.StoreManagementServiceOuterClass.AddStoreRequest.class,
      responseType = im.StoreManagementServiceOuterClass.AddStoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<im.StoreManagementServiceOuterClass.AddStoreRequest,
      im.StoreManagementServiceOuterClass.AddStoreResponse> getAddStoreMethod() {
    io.grpc.MethodDescriptor<im.StoreManagementServiceOuterClass.AddStoreRequest, im.StoreManagementServiceOuterClass.AddStoreResponse> getAddStoreMethod;
    if ((getAddStoreMethod = StoreManagementServiceGrpc.getAddStoreMethod) == null) {
      synchronized (StoreManagementServiceGrpc.class) {
        if ((getAddStoreMethod = StoreManagementServiceGrpc.getAddStoreMethod) == null) {
          StoreManagementServiceGrpc.getAddStoreMethod = getAddStoreMethod =
              io.grpc.MethodDescriptor.<im.StoreManagementServiceOuterClass.AddStoreRequest, im.StoreManagementServiceOuterClass.AddStoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.StoreManagementServiceOuterClass.AddStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.StoreManagementServiceOuterClass.AddStoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StoreManagementServiceMethodDescriptorSupplier("addStore"))
              .build();
        }
      }
    }
    return getAddStoreMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StoreManagementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StoreManagementServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StoreManagementServiceStub>() {
        @java.lang.Override
        public StoreManagementServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StoreManagementServiceStub(channel, callOptions);
        }
      };
    return StoreManagementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StoreManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StoreManagementServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StoreManagementServiceBlockingStub>() {
        @java.lang.Override
        public StoreManagementServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StoreManagementServiceBlockingStub(channel, callOptions);
        }
      };
    return StoreManagementServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StoreManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StoreManagementServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StoreManagementServiceFutureStub>() {
        @java.lang.Override
        public StoreManagementServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StoreManagementServiceFutureStub(channel, callOptions);
        }
      };
    return StoreManagementServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * this is additional rpc that would be required later
     * rpc assignStoreManager(AssignStoreManagerRequest) returns (AssignStoreManagerResponse);
     * rpc getStoreManager(GetStoreManagerRequest) returns (GetStoreManagerResponse);
     * </pre>
     */
    default void addStore(im.StoreManagementServiceOuterClass.AddStoreRequest request,
        io.grpc.stub.StreamObserver<im.StoreManagementServiceOuterClass.AddStoreResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddStoreMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StoreManagementService.
   */
  public static abstract class StoreManagementServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StoreManagementServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StoreManagementService.
   */
  public static final class StoreManagementServiceStub
      extends io.grpc.stub.AbstractAsyncStub<StoreManagementServiceStub> {
    private StoreManagementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StoreManagementServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * this is additional rpc that would be required later
     * rpc assignStoreManager(AssignStoreManagerRequest) returns (AssignStoreManagerResponse);
     * rpc getStoreManager(GetStoreManagerRequest) returns (GetStoreManagerResponse);
     * </pre>
     */
    public void addStore(im.StoreManagementServiceOuterClass.AddStoreRequest request,
        io.grpc.stub.StreamObserver<im.StoreManagementServiceOuterClass.AddStoreResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddStoreMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StoreManagementService.
   */
  public static final class StoreManagementServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StoreManagementServiceBlockingStub> {
    private StoreManagementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreManagementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StoreManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * this is additional rpc that would be required later
     * rpc assignStoreManager(AssignStoreManagerRequest) returns (AssignStoreManagerResponse);
     * rpc getStoreManager(GetStoreManagerRequest) returns (GetStoreManagerResponse);
     * </pre>
     */
    public im.StoreManagementServiceOuterClass.AddStoreResponse addStore(im.StoreManagementServiceOuterClass.AddStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddStoreMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StoreManagementService.
   */
  public static final class StoreManagementServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<StoreManagementServiceFutureStub> {
    private StoreManagementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreManagementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StoreManagementServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * this is additional rpc that would be required later
     * rpc assignStoreManager(AssignStoreManagerRequest) returns (AssignStoreManagerResponse);
     * rpc getStoreManager(GetStoreManagerRequest) returns (GetStoreManagerResponse);
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<im.StoreManagementServiceOuterClass.AddStoreResponse> addStore(
        im.StoreManagementServiceOuterClass.AddStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddStoreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_STORE = 0;

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
        case METHODID_ADD_STORE:
          serviceImpl.addStore((im.StoreManagementServiceOuterClass.AddStoreRequest) request,
              (io.grpc.stub.StreamObserver<im.StoreManagementServiceOuterClass.AddStoreResponse>) responseObserver);
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
          getAddStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              im.StoreManagementServiceOuterClass.AddStoreRequest,
              im.StoreManagementServiceOuterClass.AddStoreResponse>(
                service, METHODID_ADD_STORE)))
        .build();
  }

  private static abstract class StoreManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StoreManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return im.StoreManagementServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StoreManagementService");
    }
  }

  private static final class StoreManagementServiceFileDescriptorSupplier
      extends StoreManagementServiceBaseDescriptorSupplier {
    StoreManagementServiceFileDescriptorSupplier() {}
  }

  private static final class StoreManagementServiceMethodDescriptorSupplier
      extends StoreManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StoreManagementServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StoreManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StoreManagementServiceFileDescriptorSupplier())
              .addMethod(getAddStoreMethod())
              .build();
        }
      }
    }
    return result;
  }
}
