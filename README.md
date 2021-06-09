## leetcode plugin 配置
- codeFileName 
```aidl
$!velocityTool.camelCaseName(${question.titleSlug})
```

- codeFileTemplate
```aidl
package leetcode.editor.cn;
${question.content}
public class $!velocityTool.camelCaseName(${question.titleSlug}){
	public static void main(String[] args) {
		Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
	}
${question.code}
}
```