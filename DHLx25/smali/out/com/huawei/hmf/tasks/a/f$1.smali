.class final Lcom/huawei/hmf/tasks/a/f$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/huawei/hmf/tasks/a/f;->onComplete(Lcom/huawei/hmf/tasks/Task;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/huawei/hmf/tasks/Task;

.field final synthetic b:Lcom/huawei/hmf/tasks/a/f;


# direct methods
.method constructor <init>(Lcom/huawei/hmf/tasks/a/f;Lcom/huawei/hmf/tasks/Task;)V
    .registers 3

    iput-object p1, p0, Lcom/huawei/hmf/tasks/a/f$1;->b:Lcom/huawei/hmf/tasks/a/f;

    iput-object p2, p0, Lcom/huawei/hmf/tasks/a/f$1;->a:Lcom/huawei/hmf/tasks/Task;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 4

    iget-object v0, p0, Lcom/huawei/hmf/tasks/a/f$1;->b:Lcom/huawei/hmf/tasks/a/f;

    invoke-static {v0}, Lcom/huawei/hmf/tasks/a/f;->a(Lcom/huawei/hmf/tasks/a/f;)Ljava/lang/Object;

    move-result-object v0

    monitor-enter v0

    :try_start_7
    iget-object v1, p0, Lcom/huawei/hmf/tasks/a/f$1;->b:Lcom/huawei/hmf/tasks/a/f;

    invoke-static {v1}, Lcom/huawei/hmf/tasks/a/f;->b(Lcom/huawei/hmf/tasks/a/f;)Lcom/huawei/hmf/tasks/OnFailureListener;

    move-result-object v1

    if-eqz v1, :cond_1e

    iget-object v1, p0, Lcom/huawei/hmf/tasks/a/f$1;->b:Lcom/huawei/hmf/tasks/a/f;

    invoke-static {v1}, Lcom/huawei/hmf/tasks/a/f;->b(Lcom/huawei/hmf/tasks/a/f;)Lcom/huawei/hmf/tasks/OnFailureListener;

    move-result-object v1

    iget-object v2, p0, Lcom/huawei/hmf/tasks/a/f$1;->a:Lcom/huawei/hmf/tasks/Task;

    invoke-virtual {v2}, Lcom/huawei/hmf/tasks/Task;->getException()Ljava/lang/Exception;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/huawei/hmf/tasks/OnFailureListener;->onFailure(Ljava/lang/Exception;)V

    :cond_1e
    monitor-exit v0

    return-void

    :catchall_20
    move-exception v1

    monitor-exit v0
    :try_end_22
    .catchall {:try_start_7 .. :try_end_22} :catchall_20

    throw v1
.end method
