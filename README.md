# liveOrderBoard

This little application have been developed by following the SOLIDE principle and using TDD (JUnit and Mockito).

The implementation of the LiveOrderBoard.orderSummary use Lambda and Stream, the advantages: code more readable and clean, the method is not complex and thank to the feature "group by" it was easy and fast to merge the specific order with the same price. This mechanism have been preferred to the loop alternative which will make the code more complex to understand and improve.
