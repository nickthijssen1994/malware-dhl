.class public abstract Lcom/huawei/agconnect/exception/AGCException;
.super Ljava/lang/Exception;


# instance fields
.field private code:I

.field private errMsg:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;I)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    iput p2, p0, Lcom/huawei/agconnect/exception/AGCException;->code:I

    iput-object p1, p0, Lcom/huawei/agconnect/exception/AGCException;->errMsg:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getCode()I
    .registers 2

    iget v0, p0, Lcom/huawei/agconnect/exception/AGCException;->code:I

    return v0
.end method

.method public getErrMsg()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/huawei/agconnect/exception/AGCException;->errMsg:Ljava/lang/String;

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, " code: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lcom/huawei/agconnect/exception/AGCException;->code:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, " message: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/huawei/agconnect/exception/AGCException;->errMsg:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
