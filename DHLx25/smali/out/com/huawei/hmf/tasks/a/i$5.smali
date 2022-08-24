.class final Lcom/huawei/hmf/tasks/a/i$5;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/huawei/hmf/tasks/OnCompleteListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/huawei/hmf/tasks/a/i;->continueWith(Ljava/util/concurrent/Executor;Lcom/huawei/hmf/tasks/Continuation;)Lcom/huawei/hmf/tasks/Task;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/huawei/hmf/tasks/OnCompleteListener<",
        "TTResult;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/huawei/hmf/tasks/a/i;

.field final synthetic b:Lcom/huawei/hmf/tasks/Continuation;

.field final synthetic c:Lcom/huawei/hmf/tasks/a/i;


# direct methods
.method constructor <init>(Lcom/huawei/hmf/tasks/a/i;Lcom/huawei/hmf/tasks/a/i;Lcom/huawei/hmf/tasks/Continuation;)V
    .registers 4

    iput-object p1, p0, Lcom/huawei/hmf/tasks/a/i$5;->c:Lcom/huawei/hmf/tasks/a/i;

    iput-object p2, p0, Lcom/huawei/hmf/tasks/a/i$5;->a:Lcom/huawei/hmf/tasks/a/i;

    iput-object p3, p0, Lcom/huawei/hmf/tasks/a/i$5;->b:Lcom/huawei/hmf/tasks/Continuation;

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
            "TTResult;>;)V"
        }
    .end annotation

    invoke-virtual {p1}, Lcom/huawei/hmf/tasks/Task;->isCanceled()Z

    move-result v0

    if-eqz v0, :cond_c

    iget-object p1, p0, Lcom/huawei/hmf/tasks/a/i$5;->a:Lcom/huawei/hmf/tasks/a/i;

    invoke-virtual {p1}, Lcom/huawei/hmf/tasks/a/i;->a()Z

    return-void

    :cond_c
    :try_start_c
    iget-object v0, p0, Lcom/huawei/hmf/tasks/a/i$5;->b:Lcom/huawei/hmf/tasks/Continuation;

    invoke-interface {v0, p1}, Lcom/huawei/hmf/tasks/Continuation;->then(Lcom/huawei/hmf/tasks/Task;)Ljava/lang/Object;

    move-result-object p1

    iget-object v0, p0, Lcom/huawei/hmf/tasks/a/i$5;->a:Lcom/huawei/hmf/tasks/a/i;

    invoke-virtual {v0, p1}, Lcom/huawei/hmf/tasks/a/i;->a(Ljava/lang/Object;)V
    :try_end_17
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_17} :catch_18

    return-void

    :catch_18
    move-exception p1

    iget-object v0, p0, Lcom/huawei/hmf/tasks/a/i$5;->a:Lcom/huawei/hmf/tasks/a/i;

    invoke-virtual {v0, p1}, Lcom/huawei/hmf/tasks/a/i;->a(Ljava/lang/Exception;)V

    return-void
.end method
