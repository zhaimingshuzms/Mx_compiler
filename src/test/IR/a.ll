define i32 @main(){
  %1 = alloca i32
  store i32 0, i32* %1
  %2 = call i32 @putchar(i32 99)
  ret i32 0
}

declare i32 @putchar(i32)