.class final Lcom/huawei/hmf/tasks/a/i$4$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/huawei/hmf/tasks/OnCompleteListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/huawei/hmf/tasks/a/i$4;->onComplete(Lcom/huawei/hmf/tasks/Task;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/huawei/hmf/tasks/OnCompleteListener<",
        "TTContinuationResult;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/huawei/hmf/tasks/a/i$4;


# direct methods
.method constructor <init>(Lcom/huawei/hmf/tasks/a/i$4;)V
    .registers 2

    iput-object p1, p0, Lcom/huawei/hmf/tasks/a/i$4$1;->a:Lcom/huawei/hmf/tasks/a/i$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onComplete(Lcom/huawei/hmf/tasks/Task;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/huawei/hmf/tasks/Task<",
            "TTContinuationResult;>;)V"
        }
    .end annotation

    invoke-virtual {p1}, Lcom/huawei/hmf/tasks/Task;->isSuccessful()Z

    move-result v0

    if-eqz v0, :cond_12

    iget-object v0, p0, Lcom/huawei/hmf/tasks/a/i$4$1;->a:Lcom/huawei/hmf/tasks/a/i$4;

    iget-object v0, v0, Lcom/huawei/hmf/tasks/a/i$4;->b:Lcom/huawei/hmf/tasks/a/i;

    invoke-virtual {p1}, Lcom/huawei/hmf/tasks/Task;->getResult()Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/huawei/hmf/tasks/a/i;->a(Ljava/lang/Object;)V

    return-void

    :cond_12
    invoke-virtual {p1}, Lcom/huawei/hmf/tasks/Task;->isCanceled()Z

    move-result v0

    if-eqz v0, :cond_20

    iget-object p1, p0, Lcom/huawei/hmf/tasks/a/i$4$1;->a:Lcom/huawei/hmf/tasks/a/i$4;

    iget-object p1, p1, Lcom/huawei/hmf/tasks/a/i$4;->b:Lcom/huawei/hmf/tasks/a/i;

    invoke-virtual {p1}, Lcom/huawei/hmf/tasks/a/i;->a()Z

    return-void

    :cond_20
    iget-object v0, p0, Lcom/huawei/hmf/tasks/a/i$4$1;->a:Lcom/huawei/hmf/tasks/a/i$4;

    iget-object v0, v0, Lcom/huawei/hmf/tasks/a/i$4;->b:Lcom/huawei/hmf/tasks/a/i;

    invoke-virtual {p1}, Lcom/huawei/hmf/tasks/Task;->getException()Ljava/lang/Exception;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/huawei/hmf/tasks/a/i;->a(Ljava/lang/Exception;)V

    return-void
.end method
